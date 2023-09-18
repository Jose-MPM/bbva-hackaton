package hackaton.bank.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Integer id_cuenta;
	
	public Cuenta(@NotNull String nombre_cliente, @NotNull Double saldo) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.saldo = saldo;
	}


	@NotNull
    @Column(name = "nombre_cliente")
	private String nombre_cliente;
	
	@NotNull
    @Column(name = "saldo")
	private Double saldo;

	//@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	//private List<Transaccion> transacciones;
	
	
    @Column(name = "status")
    @Min(value=0)
    @Max(value=1)
    private Integer status;
	

	@Override
	public String toString() {
		return "Cuenta [cuenta_id=" + id_cuenta + ", nombre_cliente=" + nombre_cliente + ", saldo=" + saldo
				+ ", status=" + status + "]";
	}




	public Integer getId_cuenta() {
		return id_cuenta;
	}




	public void setId_cuenta(Integer id_cuenta) {
		this.id_cuenta = id_cuenta;
	}




	public String getNombre_cliente() {
		return nombre_cliente;
	}




	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}




	public Double getSaldo() {
		return saldo;
	}




	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}




	public Integer getStatus() {
		return status;
	}




	public void setStatus(Integer status) {
		this.status = status;
	}

}
