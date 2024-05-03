package clasesdaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entitys.Persona;
import interfacesdao.IPersonaDAO;

public class PersonaDAO implements IPersonaDAO {
	EntityManager em;
	
	public PersonaDAO() {
		em = SingletonEntityManager.getInstance().getEntityManager();
		// TODO Auto-generated constructor stub
	}
	
	public void createPersona(Persona persona) {
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(persona);
		etx.commit();
	}

}
