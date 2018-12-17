package br.com.gscapotaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gscapotaria.domain.Categoria;
import br.com.gscapotaria.domain.Produto;
import br.com.gscapotaria.repositories.CategoriaRepository;
import br.com.gscapotaria.repositories.ProdutoRepository;

@SpringBootApplication
public class GscapotariaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		
		Produto p1 = new Produto(null, "Sofás tradicionais", 500.00);
		Produto p2 = new Produto(null, "Sofás retráteis", 1000.00);
		Produto p3 = new Produto(null, "Sofás Divã", 800.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}

