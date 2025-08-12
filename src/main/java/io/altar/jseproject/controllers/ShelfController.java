package io.altar.jseproject.controllers;

import java.util.List;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

//serviços e modelos
import io.altar.jseproject.business.ShelfService;
import io.altar.jseproject.model.Shelf;

@Path("shelves")
//coloquei o consumes e produces na classe pq assim evita repetição nas anotações dos métodos. Se usar aqui ja n preciso usar depois.
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ShelfController { //é como se fosse o textinterface só q pra api. Classe que define os endpoints REST
	
	@Inject
	private ShelfService shelfService;
	//private final ShelfService shelfservice = new ShelfService(); //indica q o shelfservice n vai mudar e evita bugs 
	@Context
	protected UriInfo context; //injeta um objeto UriInfo q contém informações sobre a URL atual da requisição HTTP
	
	//health check - p saber se o controller está ativo e acessível
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return context.getRequestUri().toString() + " is ok";
	}
	
	//cria prateleira
	@POST
	public long createShelf(Shelf shelf) {
		return shelfService.create(shelf);
	}
	
	//ir buscar uma prateleira pelo id
	@GET
	@Path("/{id}")
	//este metodo responde ao GET /shelves/2 (por ex) e devolve a prateleira c id 2
	public Shelf getById(@PathParam("id") long id) {
		return shelfService.getById(id);
	}
	
	//listar todas as prateleiras
	@GET
	public List<Shelf> getAllShelves() {// responde ao get /shelves e devolve todas as prateleiras q existam
		return shelfService.getAll();	
	}
	
	//editar uma prateleira existente
	@PUT
	@Path("/{id}")
	public void editShelf(@PathParam("id") long id, Shelf shelf) { // responde ao PUT /shelves/2 c um json no corpo e edita a prateleira c o id 2 (ex)
		shelf.setId(id); //garante q o id do obj é o msm da URL
		shelfService.edit(shelf);
	}
	
	//deleta uma prateleira pelo id
	@DELETE
	@Path("/{id}")
	public void deleteShelf(@PathParam("id") long id) {
		shelfService.remove(id);
		}
	}
