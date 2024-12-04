package models;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.fatecpg.projetop2.controller", "br.edu.fatecpg.projetop2.service", "br.edu.fatecpg.projetop2.repository"})
public class Projetop2Application {
	public static void main(String[] args) {
		SpringApplication.run(Projetop2Application.class, args);
	}
}
