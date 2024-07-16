package alura.Foro_Hub.controller;

import alura.Foro_Hub.domain.curso.Curso;
import alura.Foro_Hub.domain.curso.CursoRepository;
import alura.Foro_Hub.domain.topicos.*;
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
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                                                UriComponentsBuilder uriBuilder) {
        Usuario autor = usuarioRepository.getReferenceById(datos.autor().id());
        Curso curso = cursoRepository.getReferenceById(datos.curso().id());

        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion).map(DatosRespuestaTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detallar(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizar(@RequestBody @Valid DatosActualizarTopico datos) {
        Topico topico = repository.getReferenceById(datos.id());
        topico.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Topico topico = repository.getReferenceById(id);
        topico.desactivar();

        return ResponseEntity.noContent().build();
    }
}
