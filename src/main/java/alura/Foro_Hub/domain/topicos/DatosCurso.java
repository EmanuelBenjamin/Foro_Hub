package alura.Foro_Hub.domain.topicos;

import alura.Foro_Hub.domain.curso.Curso;

public record DatosCurso(Long id, String nombre) {
    public DatosCurso(Curso curso) {
        this(curso.getId(), curso.getNombre());
    }
}
