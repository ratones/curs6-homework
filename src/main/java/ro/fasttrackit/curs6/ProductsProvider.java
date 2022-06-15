package ro.fasttrackit.curs6;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs6.model.Product;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static ro.fasttrackit.curs6.model.ProductCategory.*;

@Component
@RequiredArgsConstructor
public class ProductsProvider {

    private final ProductRepository repository;
    public void generateProducts() {
        List.of(
                new Product(1,"Samsung TV", new Random().nextInt(1500,2500), "Samsung TV", VIDEO),
                new Product(2,"SONY TV", new Random().nextInt(1500,2500), "SONY TV", VIDEO),
                new Product(3,"LG TV", new Random().nextInt(1500,2500), "LG TV", VIDEO),
                new Product(4,"IPhone 13", new Random().nextInt(500,2500), "IPhone", PHONES),
                new Product(5,"Samsung A53", new Random().nextInt(500,2500), "Samsung", PHONES),
                new Product(6,"Huawei", new Random().nextInt(500,2500), "Huawei", PHONES),
                new Product(7,"Bosch Microwave", new Random().nextInt(150,2500), "Microwave", APPLIANCE),
                new Product(8,"Brand", new Random().nextInt(150,2500), "Mixer", APPLIANCE),
                new Product(9,"Star", new Random().nextInt(150,2500), "Toaster", APPLIANCE),
                new Product(10,"Philips", new Random().nextInt(150,2500), "LED Light", LIGHT),
                new Product(11,"Some Product", new Random().nextInt(150,2500), "", LIGHT),
                new Product(12,"Other Product", new Random().nextInt(150,2500), "LED Light", LIGHT)
        ).stream().toList().forEach(repository::save);
    }
}
