package misservlets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Usuario {
	private String name;
	private String zipcode;
	private Map<String, Integer> cantidadGolosinas;
	private Map<String, Integer> precios;
	
	public Usuario() {
		super();
		cantidadGolosinas = new HashMap<String, Integer>();
		precios = new HashMap<String, Integer>();
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
		cantidadGolosinas.put(golosina, cantidad);
	}
	
	public Integer getCantidadGolosina(String golosina) {
		return cantidadGolosinas.get(golosina);
	}
	
	public void setPrecioGolosina(String golosina, Integer precio) {
		precios.put(golosina, precio);
	}
	
	public Integer getPrecioGolosina(String golosina) {
		return precios.get(golosina);
	}
	
	public Integer getPrecioCantidadGolosina(String golosina) {
		return precios.get(golosina) * cantidadGolosinas.get(golosina);
	}
	
	public Set<String> getGolosinas() {
		return precios.keySet();
	}
	
	public Integer getPrecioTotal() {
		return this.getGolosinas().stream()
					.mapToInt(golosina -> this.getPrecioCantidadGolosina(golosina))
					.sum();
		
	}
	
	public void resetGolosinas() {
		cantidadGolosinas.clear();
		precios.clear();
	}
}
