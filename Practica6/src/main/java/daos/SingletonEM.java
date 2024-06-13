package daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEM {
	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("miUP");
		return emf;
	}
}
