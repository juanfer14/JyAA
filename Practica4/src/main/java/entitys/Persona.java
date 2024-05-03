package entitys;

import javax.persistence.*;

@Entity
@Table(name="visitante")
public class Persona implements java.io.Serializable {
	
	@Id
	private long id;
	private String nombre;
	private String apellido;

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
