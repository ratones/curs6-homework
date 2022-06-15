package ro.fasttrackit.curs6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs6.exceptions.InvalidProductException;
import ro.fasttrackit.curs6.exceptions.ResourceNotFoundException;
import ro.fasttrackit.curs6.model.Product;
import ro.fasttrackit.curs6.model.ProductCategory;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    @GetMapping()
    List<Product> getProducts(ProductCategory category, Long maxPrice){
        return service.getProducts(category, maxPrice);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable() int id) throws ResourceNotFoundException {
        return service.getProduct(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @PostMapping()
    Product createProduct(@RequestBody Product product) throws InvalidProductException {
        return service.createProduct(product);
    }

    @DeleteMapping("{id}")
    Product deleteProduct(@PathVariable() int id){
        return service.deleteProduct(id).orElse(null);
    }
}
