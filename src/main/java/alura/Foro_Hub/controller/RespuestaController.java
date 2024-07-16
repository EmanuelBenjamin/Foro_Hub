package alura.Foro_Hub.controller;

import alura.Foro_Hub.domain.respuesta.*;
import alura.Foro_Hub.domain.topicos.Topico;
import alura.Foro_Hub.domain.topicos.TopicoRepository;
import alura.Foro_Hub.domain.usuarios.Usuario;
import alura.Foro_Hub.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaRespuesta> registrar(@RequestBody @Valid DatosRegistroRespuesta datos,
                                                             UriComponentsBuilder uriBuilder) {
        Topico topico = topicoRepository.getReferenceById(datos.topicoId());
        Usuario autor = usuarioRepository.getReferenceById(datos.autorId());
        Respuesta respuesta = new Respuesta(datos.mensaje(), topico, autor);
        repository.save(respuesta);

        var uri = uriBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaRespuesta(respuesta));
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaRespuesta>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        var page = repository.findAll(paginacion).map(DatosRespuestaRespuesta::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaRespuesta> actualizar(@RequestBody @Valid DatosActualizarRespuesta datos) {
        Respuesta respuesta = repository.getReferenceById(datos.id());
        respuesta.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosRespuestaRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Respuesta respuesta = repository.getReferenceById(id);
        repository.delete(respuesta);

        return ResponseEntity.noContent().build();
    }
}

