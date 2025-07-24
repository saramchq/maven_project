package io.altar.jseproject.repositories.interfaces;

import java.util.List;
import io.altar.jseproject.model.Product;

//uma interface nao implementa métodos, apenas declara
public interface ProductInterface { //qualquer classe que implemente esta classe tem de ter estes métodos:	
	
	long create(Product entity);
	Product getById(Long id);
	List<Product> getAll();
	void edit(Product entity);
	void remove(Long id);
}
