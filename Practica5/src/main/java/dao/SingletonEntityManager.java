package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;



public class SingletonEntityManager {
	private static SingletonEntityManager sem;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	private SingletonEntityManager() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("miUP");
		em = emf.createEntityManager();
	}
	
	public static SingletonEntityManager getInstance() {
		if(sem == null)
			sem = new SingletonEntityManager();
		return sem;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

}
