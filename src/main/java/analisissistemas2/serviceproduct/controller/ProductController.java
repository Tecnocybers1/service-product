package analisissistemas2.serviceproduct.controller;


import analisissistemas2.serviceproduct.entity.Category;
import analisissistemas2.serviceproduct.entity.Product;
import analisissistemas2.serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //indicamos que aca implmentaremos un servicio rest
@RequestMapping (value="/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        //filtra por producto
        List<Product> products = new ArrayList<>();
        if (null == categoryId) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            //filtra por categoria
        } else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());

            if (products.isEmpty()) {
                return ResponseEntity.notFound().build(); // si aca no encuentra nada nos regresa valor 204 http
            }
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        if (null == product) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreate = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        Product productDB= productService.updateProduct(product);
        if (productDB == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productDB);
    }
}
