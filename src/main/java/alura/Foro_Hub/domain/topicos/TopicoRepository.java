package alura.Foro_Hub.domain.topicos;

import alura.Foro_Hub.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensaje(String tituloTopico, String mensajeTopico);
    void removeById(Long id);
    Page<Topico> findAllByCurso(Curso curso, Pageable paginacion);
    Page<Topico> findAllByActivoTrue(Pageable paginacion);
    Page<Topico> findAllByActivoFalse(Pageable paginacion);
}
