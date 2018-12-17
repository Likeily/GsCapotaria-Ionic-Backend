package br.com.gscapotaria.repositories;
//DAO acesso ao banco de dados atraves de requisições.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gscapotaria.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	
	
}
