package daos;

import java.io.Serializable;
import java.util.List;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public class UsuarioDAO implements IUsuarioDAO {
	private EntityManagerFactory emf;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
		this.emf = SingletonEM.getEntityManagerFactory();
	}

	@Override
	public List<Usuario> getAll() {
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> rootEntry = cq.from(Usuario.class);
		CriteriaQuery<Usuario> all = cq.select(rootEntry);
		return em.createQuery(cq).getResultList();
	}
	
	@Override
	public Usuario read(Serializable id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Usuario usuario = em.find(Usuario.class, id);
		em.close();
		return usuario;
	}
	
	@Override
	public Usuario readByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		Usuario usuario = null;
		try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
            query.setParameter("email", email);
            usuario = query.getSingleResult();
		} catch (NoResultException e) {
			usuario = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
		return usuario;
	}

	@Override
	public Usuario create(Usuario usuario) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = null;
		try {
			etx = em.getTransaction();
			etx.begin();
			em.persist(usuario);
			etx.commit();
		} catch(RuntimeException e) {
			if(etx != null && etx.isActive())
				etx.rollback();
			throw e;
		}
		em.close();
		return usuario;
	}


	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = null;
		Usuario usr = null;
		try {
			etx = em.getTransaction();
			etx.begin();
			usr = em.merge(usuario);
			etx.commit();
		} catch(RuntimeException e) {
			if(etx != null && etx.isActive())
				etx.rollback();
			throw e;
		}
		em.close();
		return usr;
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setActivo(false);
		this.update(usuario);
	}
	
	

}
