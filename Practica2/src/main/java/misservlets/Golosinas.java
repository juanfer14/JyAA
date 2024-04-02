package misservlets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Golosinas {
	
	private static Golosinas INSTANCE;
	private Map<String, Integer> precios;

	public Golosinas() {
		precios = new HashMap<String, Integer>();
		// TODO Auto-generated constructor stub
	}
	
	public static Golosinas getInstance() {
		if(INSTANCE == null)
			INSTANCE = new Golosinas();
		return INSTANCE;
	}
	
	public Integer getPrecio(String golosina) {
		return precios.get(golosina);
	}
	
	public void setGolosina(String golosina, Integer precio) {
		precios.put(golosina, precio);
	}
	
	public Set<String> getGolosinas(){
		return precios.keySet();
	}
	
	

}
