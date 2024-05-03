package clasesdaoImpl;

import interfacesdao.IItemsDAO;
import interfacesdao.IPersonaDAO;

public class FactoryDAO {

	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static IPersonaDAO getPersonaDAO() {
		return new PersonaDAO();
	}
	
	public static IItemsDAO getItemsDAO() {
		return new ItemsDAO();
	}

}
