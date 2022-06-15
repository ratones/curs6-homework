package ro.fasttrackit.curs6;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class DataGenerator {
    private final ProductsProvider provider;

    public void generateProducts(){
        provider.generateProducts();
    }
}
