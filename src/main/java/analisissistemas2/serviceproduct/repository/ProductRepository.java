package analisissistemas2.serviceproduct.repository;

import analisissistemas2.serviceproduct.entity.Category;
import analisissistemas2.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    public List<Product>findByCategory(Category category);
}
