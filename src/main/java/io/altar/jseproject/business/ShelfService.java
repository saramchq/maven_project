package io.altar.jseproject.business;

import java.util.List;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService {

	private final ShelfRepository shelfRepository = ShelfRepository.getInstance();
	// não pode ser alterado fora da classe
    //este é o unico ponto de comunicaçao coma  camada de persistencia
    //cria uma variável chamada shelfRepository, que é do tipo shelfRepository, e guarda nela a única instância existente (padrão Singleton)
    
	//cria uma nova prateleria e devolve o id atribuido
	public long create(Shelf shelf) {
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
		shelfRepository.edit(shelf);
	}

	// Remove uma prateleira pelo ID
	public void remove(long id) {
		shelfRepository.remove(id);
	}
}
