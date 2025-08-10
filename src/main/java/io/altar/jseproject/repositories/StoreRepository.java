package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.model.Store;

@ApplicationScoped
public class StoreRepository {

	private Map<Long, Store> stores = new HashMap<>();
	private long currentId = 1; // auto incremento
	
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
	
	
	//criar
	public Store create(Store store) {
		store.setId(currentId++);
		stores.put(store.getId(), store);
		return store;
	}
	
	//buscar por id
	public Store getById(long id) {
		return stores.get(id);
	}
	
	//buscar todos
	public Collection<Store> getAll() {
		return stores.values();
	}
	
	//editar
	public void edit(Store store) {
		stores.put(store.getId(), store);
	}
	
	//remover
	public void remove(long id) {
		stores.remove(id);
	}
	
}
