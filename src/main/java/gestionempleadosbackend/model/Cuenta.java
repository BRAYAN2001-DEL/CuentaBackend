package gestionempleadosbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cuenta")
public class Cuenta {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne 
	@JoinColumn (name = "id_cliente")
	private Cliente cliente;
	@Column (name = "numero_cuenta")
	private String numero_cuenta;
	@Column (name = "tipo_cuenta")
	private String tipo_cuenta;
	@Column (name = "saldo_Inicial")
	 private Double saldo_Inicial;
	@Column (name = "estado")
	private Boolean estado;
	
	
	
	
	
	public Cuenta() {
		
	}





	public Cuenta(int id, Cliente cliente, String numero_cuenta, String tipo_cuenta, Double saldo_Inicial,
			Boolean estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.numero_cuenta = numero_cuenta;
		this.tipo_cuenta = tipo_cuenta;
		this.saldo_Inicial = saldo_Inicial;
		this.estado = estado;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Cliente getCliente() {
		return cliente;
	}





	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}





	public String getNumero_cuenta() {
		return numero_cuenta;
	}





	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}





	public String getTipo_cuenta() {
		return tipo_cuenta;
	}





	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}





	public Double getSaldo_Inicial() {
		return saldo_Inicial;
	}





	public void setSaldo_Inicial(Double saldo_Inicial) {
		this.saldo_Inicial = saldo_Inicial;
	}





	public Boolean getEstado() {
		return estado;
	}





	public void setEstado(Boolean estado) {
		this.estado = estado;
	}





	 
}
