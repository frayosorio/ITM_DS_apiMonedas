package apimonedas.apimonedas.core.entidades;

import java.sql.Date;

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
@Table(name = "cambiomoneda")
public class CambioMoneda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CambioMoneda_Secuencia")
    @GenericGenerator(name = "CambioMoneda_Secuencia", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "valor")
    private double valor;

    public CambioMoneda() {
    }

    public CambioMoneda(Moneda moneda, Date fecha, double valor) {
        this.moneda = moneda;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
