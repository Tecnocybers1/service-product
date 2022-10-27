package analisissistemas2.serviceproduct.service;

import analisissistemas2.serviceproduct.entity.Category;
import analisissistemas2.serviceproduct.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listAllProduct();
    public Product getProduct(long id);

    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct (long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock (long id, Double Quantity);


}
