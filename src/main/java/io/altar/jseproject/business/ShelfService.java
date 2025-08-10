package io.altar.jseproject.business;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

@ApplicationScoped
public class ShelfService {
	
	@Inject
	private ShelfRepository shelfRepository;
	
	@Inject
	private ProductRepository productRepository;
	

	/*
	 * private final ShelfRepository shelfRepository =
	 * ShelfRepository.getInstance(); private final ProductRepository
	 * productRepository = ProductRepository.getInstance();
	 */

	// não pode ser alterado fora da classe
    //este é o unico ponto de comunicaçao coma  camada de persistencia
    //cria uma variável chamada shelfRepository, que é do tipo shelfRepository, e guarda nela a única instância existente (padrão Singleton)
    
	//cria uma nova prateleria e devolve o id atribuido
	public long create(Shelf shelf) {
		 // 1. Capacidade tem de ser maior que 0
	    if (shelf.getCapacidade() <= 0) {
	        throw new WebApplicationException("Capacidade tem de ser maior que 0", 400);
	    }

	    // 2. Preço de aluguer não pode ser negativo
	    if (shelf.getPrecoAluguer() < 0) {
	        throw new WebApplicationException("Preço de aluguer não pode ser negativo", 400);
	    }

	    // 3. Se a prateleira estiver associada a um produto, esse produto tem de existir
	    if (shelf.getIdProduto() != 0 && productRepository.getById(shelf.getIdProduto()) == null) {
	        throw new WebApplicationException("Produto com ID " + shelf.getIdProduto() + " não existe", 400);
	    }
		return shelfRepository.create(shelf);
	}

	// Vai buscar uma prateleira pelo ID e devolve null se n existir
	public Shelf getById(long id) {
		return shelfRepository.getById(id);
	}

	// Devolve todas as prateleiras guardadas
	public List<Shelf> getAll() {
		return shelfRepository.getAll();
	}

	// Edita uma prateleira existente
	public void edit(Shelf shelf) {
		 // 1. Capacidade tem de ser maior que 0
	    if (shelf.getCapacidade() <= 0) {
	        throw new WebApplicationException("Capacidade tem de ser maior que 0", 400);
	    }

	    // 2. Preço de aluguer não pode ser negativo
	    if (shelf.getPrecoAluguer() < 0) {
	        throw new WebApplicationException("Preço de aluguer não pode ser negativo", 400);
	    }

	    // 3. Se a prateleira estiver associada a um produto, esse produto tem de existir
	    if (shelf.getIdProduto() != 0 && productRepository.getById(shelf.getIdProduto()) == null) {
	        throw new WebApplicationException("Produto com ID " + shelf.getIdProduto() + " não existe", 400);
	    }
		shelfRepository.edit(shelf);
	}

	// Remove uma prateleira pelo ID
	public void remove(long id) {
		shelfRepository.remove(id);
	}
}
