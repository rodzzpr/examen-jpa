package ni.edu.uam.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(
                name = "autores.All",
                query = "select a from Autor a"
        )
})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_autor", length = 60, nullable = false)
    private String nombre;

    @Column(name = "nacionalidad", length = 60, nullable = false)
    private String nacionalidad;

    private LocalDate fechaNac;
}
