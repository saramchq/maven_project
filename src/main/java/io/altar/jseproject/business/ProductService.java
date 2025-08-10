package io.altar.jseproject.business;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

@ApplicationScoped
public class ProductService { //camada intermedia
	
	@Inject
	private ProductRepository productRepository; // cdi injeta a instancia sem o getinstance
	
	
	
    // private final ProductRepository productRepository = ProductRepository.getInstance(); // não pode ser alterado fora da classe
    //este é o unico ponto de comunicaçao com a camada de persistencia ( parte do teu projeto responsável por guardar, buscar, editar e remover dados)
    //cria uma variável chamada productRepository, que é do tipo ProductRepository, e guarda nela a única instância existente (padrão Singleton)
    
    
    //cria produto e devolve o id gerado
    public long create(Product product) {
		//validaçoes p garantir que os dados estão corretos antes de serem guardados
		if (product.getPvp() <= 0) {
			throw new WebApplicationException("PVP inválido", 400);
		}
		
		if (product.getIva() < 0 || product.getIva() > 1) {
			throw new WebApplicationException("IVA deve estar entre 0 e 1 (ex: 0.23 para 23%)", 400);
		}
		
		if (product.getDescontoUni() < 0 ) {
			throw new WebApplicationException("Desconto unitário não pode ser negativo", 400);
		}
		
        return productRepository.create(product);
    }

    //devolve a partir do id ou ent da null se n existir
    public Product getById(long id) {
        return productRepository.getById(id);
    }

    //devolve a lista de todos os produtos guardados no repositorio
    public List<Product> getAll() {
        return productRepository.getAll();
    }
    
    //edita os dados de um produto existente
    public void edit(Product product) {
    	if (product.getPvp() <= 0) {
            throw new WebApplicationException("PVP deve ser maior que 0", 400);
        }

        if (product.getIva() < 0 || product.getIva() > 1) {
            throw new WebApplicationException("IVA deve estar entre 0 e 1", 400);
        }

        if (product.getDescontoUni() < 0) {
            throw new WebApplicationException("Desconto unitário não pode ser negativo", 400);
        }
        productRepository.edit(product);
    }
    
    //remove um produto do repositorio c base no id
    public void remove(long id) {
        productRepository.remove(id);
    }
}