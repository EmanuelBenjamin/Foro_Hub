package alura.Foro_Hub.domain.topicos;

import alura.Foro_Hub.domain.curso.Curso;
import alura.Foro_Hub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private  String titulo;

    @Column(columnDefinition = "TEXT")
    private  String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ENVIADO;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(name = "cantidad_respuestas")
    private Integer respuestas = 0;

    private boolean activo = true;
    public Topico(
            String titulo,
            String mensaje,
            Usuario autor,
            Curso curso
    ){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;

    }
    public void actualizarInformacion(DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
    }

    public void desactivar() {
        this.activo = false;
    }


}


