package io.altar.jseproject.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.interfaces.ProductInterface;

//o ProductRepository implementa a interface e é obrigado a ter todos os métodos
@ApplicationScoped // uma instância para toda a app
public class ProductRepository extends EntityRepository<Product> implements ProductInterface {
	
	@PersistenceContext(unitName = "mypersistence")
	private EntityManager em;
	
	@Override //Garante que a assinatura do método está igual à definida na classe pai
	public long create(Product p) {
		em.persist(p); // adiciona o objeto ao contexto de persistência e faz um INSERT quando a transação for confirmada
		return p.getId(); //id gerado
	}
	
	@Override
	public Product getById(Long id) {
		return em.find(Product.class, id); //SELECT por primary key
	}
	
	@Override
	public List<Product> getAll() {
		return em.createQuery("SELECT p FROM Product p", Product.class)
				.getResultList(); //JPQL, é tipo o SQL só q baseado em entidades e não em tabelas
	}
	
	@Override
	public void edit(Product p) {
		em.merge(p); //UPDATE , se o objeto não estiver a ser gerido no contexto de persistência, o merge cria uma cópia gerida e aplica o update
	}
	
	@Override
	public void remove(Long id) {
		Product managed = em.find(Product.class, id);
		if(managed != null) em.remove(managed); //DELETE , o remove só funciona com entidades geridas pelo EntityManager por isso primeiro vou buscar c o find
	}
}

	
	
	
	/*//cria o atributo INSTANCE (unico e final)
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	//metodo p aceder a instancia unica
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	//construitor pvd (ngm pode criar instancias de fora)
	private ProductRepository() {}
}*/


