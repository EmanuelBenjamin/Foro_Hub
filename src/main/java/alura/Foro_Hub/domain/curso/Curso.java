package alura.Foro_Hub.domain.curso;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private EstadoCurso estado;

    private boolean activo =true;

    public Curso(
            String nombre,
            Categoria categoria) {

        this.nombre = nombre;
        this.categoria = categoria;
        this.estado = EstadoCurso.ACTIVO;
    }
}
