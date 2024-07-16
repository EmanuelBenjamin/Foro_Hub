package alura.Foro_Hub.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    //Verifica si existe el curso con el nombre especificado
    boolean existsByNombre(String nombre);

    //Obtiene una pagina con los cursos activos
    Page<Curso> findByActivoTrue(Pageable paginacion);

    //Obtiene una pagina con los cursos inactivos.
    Page<Curso> findByActivoFalse(Pageable paginacion);
}
