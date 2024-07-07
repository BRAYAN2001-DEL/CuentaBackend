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
@Table (name = "persona")
public class Persona {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name = "nombre")
	private String nombre;
	@Column (name = "apellido")
	private String apellido;
	@Column (name = "edad")
	private int edad;
	@Column (name = "genero")
	private String genero;
	@Column (name = "identificacion")
	private String identificacion;
	@Column (name = "direccion")
	private String  direccion;
	@Column (name = "telefono")
	private String telefono;
	
	public Persona() {
	}
	
	
	
	 




	public Persona(int id, String nombre, String apellido, int edad, String genero, String identificacion,
			String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
	}








	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}






	public String getIdentificacion() {
		return identificacion;
	}






	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}






	public String getDireccion() {
		return direccion;
	}






	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}






	public String getTelefono() {
		return telefono;
	}






	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
