package com.cpan252.brands;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan252.brands.model.item;
import com.cpan252.brands.model.item.Brand;
import com.cpan252.brands.repository.itemRepository;

@SpringBootApplication
public class BrandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrandsApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(itemRepository repository) {
		return args -> {
			repository.save(item.builder()
			.name("King")
			.brandFrom(Brand.Balenciaga)
			.price(20000)
			.yearcreated(2024).build());
		};

}
	}
