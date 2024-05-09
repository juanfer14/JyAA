package entitys;

import javax.persistence.*;

@Entity
@Table(name="visitante")
public class Persona implements java.io.Serializable {
	
	@Id
	private long id;
	private String nombre;
	private String email;

	public Persona(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setApellido(String email) {
		this.email = email;
	}

}
