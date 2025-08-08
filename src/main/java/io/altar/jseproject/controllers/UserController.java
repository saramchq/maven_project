package io.altar.jseproject.controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.UserService;
import io.altar.jseproject.model.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

	private final UserService userService = new UserService();
	
	//criar utilizador
	@POST
	public User createUser(User user) {
		return userService.create(user);
	}
	
	//listar tds os utilizadores
	@GET
	public Collection<User> getAllUsers(){
		return userService.getAll();
	}
	
	//Editar utilizador
	@PUT
	public void edit(User user) {
		userService.edit(user);
	}
	
	//Remover utilizador por id
	@DELETE
	@Path("/{id}")
	public void removeUser(@PathParam("id") long id) {
		userService.remove(id);
	}
	
	//associar loja a um uti
	@POST
	@Path("/{userId}/stores/{storeId}")
	public void associarStore(@PathParam("userId") long userId, @PathParam("storeId") long storeId) {
		userService.associarStore(userId, storeId);
	}
}

