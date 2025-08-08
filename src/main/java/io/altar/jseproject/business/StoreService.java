package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Store;
import io.altar.jseproject.repositories.StoreRepository;

public class StoreService {

    private final StoreRepository storeRepository = StoreRepository.getInstance();

    // criar uma Store
    public Store create(Store store) {
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
    public void edit(Store store) {
        storeRepository.edit(store);
    }

    // remover Store por ID
    public void remove(long id) {
        storeRepository.remove(id);
    }

    // associar utilizador a uma Store
    public void associarUser(long storeId, long userId) {
        Store store = storeRepository.getById(storeId);
        if (store != null) {
            store.getUserIds().add(userId);
            storeRepository.edit(store);
        }
    }
}
