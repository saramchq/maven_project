package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ProductInterface;

//o ProductRepository implementa a interface e é obrigado a ter todos os métodos
public class ProductRepository extends EntityRepository<Product> implements ProductInterface {
	//cria o atributo INSTANCE (unico e final)
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	//metodo p aceder a instancia unica
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	//construitor pvd (ngm pode criar instancias de fora)
	private ProductRepository() {}
}


