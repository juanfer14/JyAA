package daos;


public class FactoryDAO {
	

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

}
