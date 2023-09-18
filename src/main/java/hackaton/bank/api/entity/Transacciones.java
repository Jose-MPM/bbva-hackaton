package hackaton.bank.api.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transacciones")
public class Transacciones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer id_transaccion;

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    private Cuenta cuenta;

    @Column(name = "tipo")
    @NotNull(message="El tipo de transaccion es requerido")
    private String tipo;

    @Column(name = "monto")
    @Min(value=0, message="El monto de la transaccion no puede ser negativo")
    private Double monto;

    @Column(name = "fecha")
    @NotNull(message="La fecha de la transaccion es requerida")
    private Date fecha;

	public Integer getId_transaccion() {
		return id_transaccion;
	}

	public void setId_transaccion(Integer id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


}
