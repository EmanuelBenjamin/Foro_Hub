package alura.Foro_Hub.domain.topicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Valid DatosAutor autor,
        @NotNull @Valid DatosCurso curso
) {}
