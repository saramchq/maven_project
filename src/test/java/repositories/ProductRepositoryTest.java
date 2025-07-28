package repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductRepositoryTest {

    private ProductRepository repo;

    @BeforeEach
    public void setup() {
        repo = ProductRepository.getInstance();
        repo.reset(); // limpa os dados antes de cada teste (certifica-te que este método existe no repositório)
    }

    @Test
    public void testCreateProduct() {
        Product p = new Product(10.0, 23.0, 100.0);
        long id = repo.create(p);
        assertEquals(p, repo.getById(id));
        assertNotNull(p.getId());
    }

    @Test
    public void testCreateProductComIdNaoNulo() {
        Product p = new Product(10.0, 23.0, 100.0);
        p.setId(99L); // não deve ter ID ao criar

        assertThrows(IllegalArgumentException.class, () -> {
            repo.create(p); // deve lançar exceção
        });
    }

    @Test
    public void testEditProduct() {
        Product p = new Product(5.0, 13.0, 50.0);
        long id = repo.create(p);
        p.setDescontoUni(7.0);
        repo.edit(p);
        assertEquals(7.0, repo.getById(id).getDescontoUni(), 0.01);
    }

    @Test
    public void testEditProductSemId() {
        Product p = new Product(5.0, 13.0, 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            repo.edit(p); // não tem ID → deve lançar exceção
        });
    }
}
