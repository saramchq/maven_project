package io.altar.jseproject.repositories;



import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.model.Store;

@ApplicationScoped
public class StoreRepository extends EntityRepository<Store> {

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

	@Override
	protected Class<Store> getEntityClass() {
		// TODO Auto-generated method stub
		return Store.class;
	}

}
