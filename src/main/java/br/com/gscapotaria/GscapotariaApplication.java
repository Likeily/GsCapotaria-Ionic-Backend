package br.com.gscapotaria;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gscapotaria.domain.Categoria;
import br.com.gscapotaria.domain.Cidade;
import br.com.gscapotaria.domain.Cliente;
import br.com.gscapotaria.domain.Endereco;
import br.com.gscapotaria.domain.Estado;
import br.com.gscapotaria.domain.Produto;
import br.com.gscapotaria.domain.enums.TipoCliente;
import br.com.gscapotaria.repositories.CategoriaRepository;
import br.com.gscapotaria.repositories.CidadeRepository;
import br.com.gscapotaria.repositories.ClienteRepository;
import br.com.gscapotaria.repositories.EnderecoRepository;
import br.com.gscapotaria.repositories.EstadoRepository;
import br.com.gscapotaria.repositories.ProdutoRepository;

@SpringBootApplication
public class GscapotariaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Rio Grande do Norte");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		Cidade c1 = new Cidade(null, "São Bento", est1);
		Cidade c2 = new Cidade(null, "Paulista", est1);
		Cidade c3 = new Cidade(null, "Brejo do Cruz", est1);
		Cidade c4 = new Cidade(null, "Jardim de Piranhas", est2);
		Cidade c5 = new Cidade(null, "Pombal", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2, c3, c5));
		est2.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
		Cliente cli1 = new Cliente(null, "Likaele Medeiros", "likaelemedeiros@gmail.com", "00100100100", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("997824757", "999898989"));
	
		Endereco e1 = new Endereco(null, "Rua Joao Alfredo", "31", "", "Sitio Novo", "34261830", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Joao Negrao", "200", "", "Santo Amaro", "34261830", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}

