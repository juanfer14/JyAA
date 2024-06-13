package daos;

import java.io.Serializable;
import java.util.List;

import model.Usuario;

public interface IUsuarioDAO {
	public List<Usuario> getAll();
	public Usuario create(Usuario usuario);
	public Usuario read(Serializable id);
	public Usuario readByEmail(String email);
	public Usuario update(Usuario usuario);
	public void delete(Usuario usuario);
}
