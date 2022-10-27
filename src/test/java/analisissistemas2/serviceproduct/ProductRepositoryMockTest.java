package analisissistemas2.serviceproduct;

import analisissistemas2.serviceproduct.entity.Category;
import analisissistemas2.serviceproduct.entity.Product;
import analisissistemas2.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        Product product01= Product.builder()
                .name("computadora")
                .category(Category.builder().id(1L).build())
                .descripcion("")
                .stock(Double.parseDouble("10"))
                .precio (Double.parseDouble("1500.45"))
                .status ("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds= productRepository.findByCategory(product01.getCategory ());

        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
