package alura.Foro_Hub.domain.respuesta;

import alura.Foro_Hub.domain.topicos.Topico;
import alura.Foro_Hub.domain.usuarios.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    boolean existsByTopicoAndSolucion(Topico topico, boolean solucion);
    boolean existsByTopicoAndMensajeAndAutor(Topico topico, String mensaje, Usuario autor);

    Page<Respuesta> findAllByTopico(Topico topico, Pageable paginacion);

    void removeAllByTopico(Topico referenceById);
}
