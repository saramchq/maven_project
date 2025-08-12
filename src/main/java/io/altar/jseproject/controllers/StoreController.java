package io.altar.jseproject.controllers;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.StoreService;
import io.altar.jseproject.model.Store;

@Path("/stores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class StoreController {
	
	@Inject
	private StoreService storeService;
    //private final StoreService storeService = new StoreService();

    // 🔹 Criar nova Store (cria automaticamente 12 prateleiras)
    @POST
    public Store createStore(Store store) {
        return storeService.create(store);
    }

    // 🔹 Listar todas as Stores
    @GET
    public Collection<Store> getAllStores() {
        return storeService.getAll();
    }

    // 🔹 Buscar Store por ID
    @GET
    @Path("/{id}")
    public Store getStoreById(@PathParam("id") long id) {
        return storeService.getById(id);
    }

    // 🔹 Editar Store
    @PUT
    public void editStore(Store store) {
        storeService.edit(store);
    }

    // 🔹 Remover Store
    @DELETE
    @Path("/{id}")
    public void deleteStore(@PathParam("id") long id) {
        storeService.remove(id);
    }

    // 🔹 Associar utilizador a uma Store (lado: Store → User)
    @POST
    @Path("/{storeId}/users/{userId}")
    public void associarUser(@PathParam("storeId") long storeId, @PathParam("userId") long userId) {
        storeService.associarUser(storeId, userId);
    }
}
