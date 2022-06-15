package ro.fasttrackit.curs6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Curs6HomeworkApplication {
	public static void main(String[] args) {
		SpringApplication.run(Curs6HomeworkApplication.class, args);
	}

	@Bean
	public DataGenerator dataGenerator(ProductsProvider provider){
		var generator = new DataGenerator(provider);
		generator.generateProducts();
		return generator;
	}
}

