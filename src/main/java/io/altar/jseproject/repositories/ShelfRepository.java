package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.interfaces.ShelfInterface;

//o ShelfRepository implementa a interface e é obrigado a ter todos os métodos
public class ShelfRepository extends EntityRepository<Shelf> implements ShelfInterface {
	// cria o atributo INSTANCE (unico e final)
	private static final ShelfRepository INSTANCE = new ShelfRepository();

	// metodo p aceder a instancia unica
	public static ShelfRepository getInstance() {
		return INSTANCE;
	}

	// construitor pvd (ngm pode criar instancias de fora)
	private ShelfRepository() {
	}
}
