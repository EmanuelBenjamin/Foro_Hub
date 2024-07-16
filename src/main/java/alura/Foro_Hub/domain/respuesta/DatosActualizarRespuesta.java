package alura.Foro_Hub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull Long id,
        String mensaje,
        Boolean solucion
) {}
