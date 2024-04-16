package clasesdaoImpl;

import interfacesdao.IPersonaDAO;

public class FactoryDAO {

	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static IPersonaDAO getPersonaDAO() {
		return new PersonaDAO();
	}

}
