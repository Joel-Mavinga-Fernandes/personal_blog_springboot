package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postagemRepository extends JpaRepository<postagem, Long>{
	public List<postagem> findAllBytituloContainingIgnoreCase (String titulo);
	
	

}
