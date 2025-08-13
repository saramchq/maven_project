package io.altar.jseproject.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.interfaces.ShelfInterface;

//o ShelfRepository implementa a interface e é obrigado a ter todos os métodos
@ApplicationScoped //uma instancia p toda a aplicação
public class ShelfRepository extends EntityRepository<Shelf> implements ShelfInterface {
	
	//n usei o persistencecontext nos filhos pq o meu ProdcutInterface ja tem os metodos crud e a implementaçao é herdada da base e ja cumpre ent n preciso reescrever
	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class; 
	}
	/*
	 * // cria o atributo INSTANCE (unico e final) private static final
	 * ShelfRepository INSTANCE = new ShelfRepository();
	 * 
	 * // metodo p aceder a instancia unica public static ShelfRepository
	 * getInstance() { return INSTANCE; }
	 * 
	 * // construitor pvd (ngm pode criar instancias de fora) private
	 * ShelfRepository() { }
	 */
}
