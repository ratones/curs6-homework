package ro.fasttrackit.curs6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs6.exceptions.InvalidProductException;
import ro.fasttrackit.curs6.model.Product;
import ro.fasttrackit.curs6.model.ProductCategory;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    public List<Product> getProducts(ProductCategory category, Long maxPrice) {
        return repository.findAll().stream()
                .filter(p -> p.filterByCategory(category))
                .filter(p -> p.filterByMaxPrice(maxPrice))
                .toList();
    }


    public Optional<Product> getProduct(int id) {
        return repository.findById(id);
    }

    public Product createProduct(Product product) throws InvalidProductException {
        validateProduct(product);
        return repository.save(product);
    }

    public Optional<Product> deleteProduct( int id) {
        var product = repository.findById(id);
        product.ifPresent(repository::delete);
        return product;
    }

    private void validateProduct(Product product) throws InvalidProductException {
        if(product.getName().isBlank()
                || product.getPrice()<=0){
            throw new InvalidProductException("Name and price must be provided for a valid product!");
        }
    }
}
