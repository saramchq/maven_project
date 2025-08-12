package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.Store;

@ApplicationScoped
public class StoreRepository {

	// private Map<Long, Store> stores = new HashMap<>();
	// private long currentId = 1; // auto incremento

	/*
	 * private static final StoreRepository INSTANCE = new StoreRepository();
	 * //singleton, garante q so existe uma instancia desta classe
	 * 
	 * private StoreRepository() {
	 * 
	 * }
	 * 
	 * public static StoreRepository getInstance() { return INSTANCE; }
	 */

	@PersistenceContext(unitName = "mypersistence")
	private EntityManager em;

	// criar
	public Store create(Store store) {
		em.persist(store); // INSERT
		// store.setId(currentId++);
		// stores.put(store.getId(), store);
		return store; // o id é preenchido pelo JPA
	}

	// buscar por id
	public Store getById(long id) {
		return em.find(Store.class, id); // SELECT por primary key
		// return stores.get(id);
	}

	// buscar todos
	public Collection<Store> getAll() {
		List<Store> list = em.createQuery("SELECT s FROM Store s", Store.class).getResultList(); // JPQL
		return list;
	}

	// editar
	public void edit(Store store) {
		em.merge(store); //UPDATE
	}

	// remover
	public void remove(long id) {
		Store managed = em.find(Store.class, id);
		if (managed != null) {
			em.remove(managed);//DELETE
		}
	}

}
