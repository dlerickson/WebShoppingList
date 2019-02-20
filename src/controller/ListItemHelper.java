package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {
//Don Erickson

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");

//always adding to the list of things to buy
	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

//this method will return a list of all items in our table/list
	public List<ListItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}

//every now and then you can remove something from the ever growing list
	public	void	deleteItem(ListItem	toDelete)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery	= em.createQuery("select li	from ListItem li where li.store	= :selectedStore and li.item = :selectedItem",	ListItem.class);
		
		//Substitute parameter with	actual data	from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem",	toDelete.getItem());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		ListItem result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	public ListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListItem> searchForItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>typedQuery = em.createQuery("SELECT li FROM ListItem li WHERE li.store = :selectedStore", ListItem.class);
		typedQuery.setParameter("selectedStore", storeName);
		
		List<ListItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListItem> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>typedQuery = em.createQuery("SELECT li FROM ListItem li WHERE li.item = :selectedItem", ListItem.class);
		typedQuery.setParameter("selectedItem", itemName);
		
		List<ListItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	//dont forget to close the emf
	public void cleanUp() {
		emfactory.close();
	}

}
