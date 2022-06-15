package ro.fasttrackit.curs6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private  int id;
    private  String name;
    private  int price;
    private  String description;
    private  ProductCategory category;

    public Product(int id, String name, int price, String description, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public boolean filterByCategory(ProductCategory category) {
        return category == null || this.category.equals(category);
    }

    public boolean filterByMaxPrice(Long maxPrice) {
        return maxPrice == null || this.price <= maxPrice;
    }
}
