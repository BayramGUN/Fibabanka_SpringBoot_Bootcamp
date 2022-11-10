package io.api.commerce;

import io.api.commerce.data.component.ProductComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CommerceApplication {
	public static ProductComponent productComponent;
	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}
	@Bean
	CommandLineRunner run(ProductComponent productComponent){
		return(args -> {
			this.productComponent = productComponent;
		});
	}

}
