package alura.Foro_Hub.domain.usuarios;

import java.time.LocalDateTime;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String email,
        LocalDateTime fechaRegistro
) {
    public DatosRespuestaUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getFechaRegistro());
    }
}
