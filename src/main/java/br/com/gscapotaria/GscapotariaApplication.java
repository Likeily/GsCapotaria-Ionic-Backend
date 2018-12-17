package br.com.gscapotaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gscapotaria.domain.Categoria;
import br.com.gscapotaria.repositories.CategoriaRepository;

@SpringBootApplication
public class GscapotariaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GscapotariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Sofás");
		Categoria cat2 = new Categoria(null, "Cabeceiras");
		Categoria cat3 = new Categoria(null, "Puff's");
		Categoria cat4 = new Categoria(null, "Poltronas");
		Categoria cat5 = new Categoria(null, "Cadeiras");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
	}

}

