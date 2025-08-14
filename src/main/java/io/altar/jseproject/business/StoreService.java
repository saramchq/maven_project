package io.altar.jseproject.business;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.model.Store;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.repositories.StoreRepository;

@ApplicationScoped
public class StoreService {
	
	@Inject
	private StoreRepository storeRepository;
	
	@Inject 
	private ShelfRepository shelfRepository;
	
	
	/*
	 * private final StoreRepository storeRepository =
	 * StoreRepository.getInstance(); private final ShelfRepository shelfRepository
	 * = ShelfRepository.getInstance();
	 */

	// criar uma Store
	@Transactional
	public long create(Store store) {
		// Cria 12 prateleiras com capacidade 10 e preço 0
		for (int i = 0; i < 12; i++) {
			Shelf shelf = new Shelf(10, 0.0);
			long shelfId = shelfRepository.create(shelf);
			store.getShelves().add(shelf);
			System.out.println("Prateleira criada com ID: " + shelfId);
		}

		// Guarda a loja no repositório
		return storeRepository.create(store);
	}

	// buscar Store por id
	public Store getById(long id) {
		return storeRepository.getById(id);
	}

	// devolver todas as Stores
	public Collection<Store> getAll() {
		return storeRepository.getAll();
	}

	// editar uma Store
	@Transactional
	public void edit(Store store) {
		storeRepository.edit(store);
	}

	// remover Store por ID
	@Transactional
	public void remove(long id) {
		storeRepository.remove(id);
	}

	// associar utilizador a uma Store
	@Transactional
	public void associarUser(long storeId, long userId) {
		Store store = storeRepository.getById(storeId);
		if (store != null) {
			store.getUserIds().add(userId);
			storeRepository.edit(store);
		}
	}
}
