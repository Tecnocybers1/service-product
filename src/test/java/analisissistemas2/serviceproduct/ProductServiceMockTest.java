package analisissistemas2.serviceproduct;

import analisissistemas2.serviceproduct.entity.Category;
import analisissistemas2.serviceproduct.entity.Product;
import analisissistemas2.serviceproduct.repository.ProductRepository;
import analisissistemas2.serviceproduct.service.ProductService;
import analisissistemas2.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest

public class ProductServiceMockTest {

    @Mock //esta parte de los accesos seran mockiados
    private ProductRepository productRepository;

    private ProductService productService;  //nuestros servicios

    @BeforeEach  // declaramos que esto se debe de hacer antes de todo los procesos
    public  void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computadora = Product.builder()
                .id(1L)
                .name("computadora")
                .category(Category.builder().id(1L).build())

                .precio (Double.parseDouble("1580.45"))
                .stock(Double.parseDouble("10"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computadora));
        Mockito.when(productRepository.save(computadora)).thenReturn(computadora);
    }
    @Test
    public void whenValidGetId_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computadora");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }

}
