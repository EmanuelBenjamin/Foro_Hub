package alura.Foro_Hub.controller;

import alura.Foro_Hub.domain.usuarios.*;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> registrar(@RequestBody @Valid DatosRegistroUsuario datos,
                                                           UriComponentsBuilder uriBuilder) {
        Usuario usuario = new Usuario(datos);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaUsuario>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        var page = repository.findAll(paginacion).map(DatosRespuestaUsuario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> actualizar(@RequestBody @Valid DatosActualizarUsuario datos) {
        Usuario usuario = repository.getReferenceById(datos.id());
        usuario.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Usuario usuario = repository.getReferenceById(id);
        repository.delete(usuario);

        return ResponseEntity.noContent().build();
    }
}
