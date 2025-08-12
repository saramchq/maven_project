package io.altar.jseproject.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

// serviços e modelos
import io.altar.jseproject.business.ProductService;
import io.altar.jseproject.business.UserService;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.User;

@Path("products")
//coloquei o consumes e produces na classe pq assim evita repetição nas anotações dos métodos. Se usar aqui ja n preciso usar depois.
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductController { // é como se fosse o TextInterface, mas para a API REST

	@Inject
	private ProductService productService;
	private UserService userService;
	//private final ProductService productService = new ProductService();
	//private final UserService userService = new UserService();


	@Context
	protected UriInfo context;

	// health check (GET /api/products/status)
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return context.getRequestUri().toString() + " is ok";
	}


	// ir buscar produto por ID (GET /api/products/5)
	@GET
	@Path("/{id}")
	public Product getById(@PathParam("id") long id) {
		return productService.getById(id);
	}

	// listar todos os produtos (GET /api/products)
	@GET
	public List<Product> getAllProducts() {
		return productService.getAll();
	}

	// editar produto (PUT /api/products/5)
	@PUT
	@Path("/{id}")
	public void editProduct(@PathParam("id") long id, Product product) {
		product.setId(id); // garante que o ID do objeto corresponde ao da URL
		productService.edit(product); 
	}

	// apagar produto (DELETE /api/products/5)
	@DELETE
	@Path("/{id}")
	public void deleteProduct(
	    @PathParam("id") long id,
	    @HeaderParam("userId") long userId) {

	    User user = userService.getById(userId);

	    if (!userService.canAccessProducts(user)) {
	        throw new WebApplicationException("Acesso negado", 403);
	    }

	    productService.remove(id);
	}
	
	//metodo q so deixa criar produtos se o utilizador tiver um role autorizado usando o id enviado pelo headparam
	@POST
	public long createProduct(Product product, @HeaderParam("userId") long userId) {
	    User user = userService.getById(userId);

	    if (!userService.canAccessProducts(user)) {
	        throw new WebApplicationException("Acesso negado", 403);
	    }

	    return productService.create(product);
	}

}
