package gestionempleadosbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "movimiento")
public class Movimiento {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne 
	@JoinColumn (name = "id_cuenta")
	private Cuenta cuenta;
	@Column (name = "fecha")
	private Date fecha; 
	@Column (name = "valor")
	private Double valor;
	@Column (name = "saldo")
	private Double saldo;
	@Column (name = "tipo_movimiento")
	private String tipo_movimiento;
	
	public Movimiento() {
	}

	public Movimiento(int id, Cuenta cuenta, Date fecha, Double valor, Double saldo, String tipo_movimiento) {
		super();
		this.id = id;
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.valor = valor;
		this.saldo = saldo;
		this.tipo_movimiento = tipo_movimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	 
	
	
	
	
}
