package alura.Foro_Hub.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estado estado,
        DatosAutor autor,
        DatosCurso curso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getEstado(),
                new DatosAutor(topico.getAutor()),
                new DatosCurso(topico.getCurso()));
    }
}
