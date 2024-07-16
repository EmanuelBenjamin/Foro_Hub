package alura.Foro_Hub.domain.topicos;


import alura.Foro_Hub.domain.usuarios.Usuario;

public record DatosAutor(Long id, String nombre) {
    public DatosAutor(Usuario autor) {
        this(autor.getId(), autor.getNombre());
    }
}
