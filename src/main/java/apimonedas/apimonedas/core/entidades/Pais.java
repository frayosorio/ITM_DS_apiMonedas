package apimonedas.apimonedas.core.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_pais")
    @GenericGenerator(name = "secuencia_pais", strategy = "increment")
    private long id;

    @Column(name = "pais", length = 100, unique = true)
    private String nombre;

    @Column(name = "codigoalfa2")
    private String codigoAlfa2;

    @Column(name = "codigoalfa3")
    private String codigoAlfa3;

    @ManyToOne
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

}
