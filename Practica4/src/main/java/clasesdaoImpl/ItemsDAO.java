package clasesdaoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import entitys.Items;
import interfacesdao.IItemsDAO;

public class ItemsDAO implements IItemsDAO {
	private EntityManager em;

	public ItemsDAO() {
		em = SingletonEntityManager.getInstance().getEntityManager();
		// TODO Auto-generated constructor stub
	}
	
	public Items getItems() {
		Query query = em.createNamedQuery("Items.find");
		return (Items) query.getSingleResult();
		
	}

}
