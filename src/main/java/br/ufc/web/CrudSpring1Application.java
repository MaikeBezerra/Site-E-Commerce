package br.ufc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrudSpring1Application {

	public static void main(String[] args) {	
		SpringApplication.run(CrudSpring1Application.class, args);		
	}
}
