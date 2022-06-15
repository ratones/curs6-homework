package ro.fasttrackit.curs6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import ro.fasttrackit.curs6.model.Product;
import ro.fasttrackit.curs6.model.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
