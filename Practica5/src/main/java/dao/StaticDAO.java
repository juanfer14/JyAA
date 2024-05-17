package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Static;


public class StaticDAO {
	private EntityManager em;
	
	public StaticDAO() {
		// TODO Auto-generated constructor stub
		em = SingletonEntityManager.getInstance().getEntityManager();
	}
	
	public void crearStatic(Static stat) {
		EntityTransaction etx = null;
		try {
			etx = em.getTransaction();
			etx.begin();
			em.persist(stat);
			etx.commit();
		} catch(Exception e) {
			if(etx != null && etx.isActive()) {
				etx.rollback();
			}
			e.printStackTrace();
		}
		
	}

}
