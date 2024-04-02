package misservlets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Usuario {
	private String name;
	private String zipcode;
	private Map<String, Integer> cantidades;
	
	public Usuario() {
		super();
		cantidades = new HashMap<String, Integer>();
	}

	public String getName() {
		return name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setCantidadGolosina(String golosina, Integer cantidad) {
		this.cantidades.put(golosina, cantidad);
	}
	
	public Integer getCantidadGolosina(String golosina) {
		return this.cantidades.get(golosina);
	}
	
	
	public Set<String> getGolosinas() {
		return this.cantidades.keySet();
	}
	
	
	public void resetGolosinas() {
		cantidades.clear();
	}
}
