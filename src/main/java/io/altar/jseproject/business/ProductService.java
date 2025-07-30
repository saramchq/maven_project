package io.altar.jseproject.business;

import java.util.List;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductService { //camada intermedia
    private final ProductRepository productRepository = ProductRepository.getInstance(); // não pode ser alterado fora da classe
    //este é o unico ponto de comunicaçao com a camada de persistencia ( parte do teu projeto responsável por guardar, buscar, editar e remover dados)
    //cria uma variável chamada productRepository, que é do tipo ProductRepository, e guarda nela a única instância existente (padrão Singleton)
    
    
    //cria produto e devolve o id gerado
    public long create(Product product) {
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
    
    //edita/atualiza os dados de um produto existente
    public void edit(Product product) {
        productRepository.edit(product);
    }
    
    //remove um produto do repositorio c base no id
    public void remove(long id) {
        productRepository.remove(id);
    }
}