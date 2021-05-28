package org.generation.blogPessoal.Controller;

import java.util.List;

import org.generation.blogPessoal.model.postagem;
import org.generation.blogPessoal.repository.postagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class postagemController {
	
	@Autowired
	private postagemRepository Repository;
	private postagem postagem;
	
	@GetMapping
	public ResponseEntity<List<postagem>>GetAll(){
		return ResponseEntity.ok(Repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<postagem> GetById(@PathVariable long id ){
		return Repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<postagem>> GetByTitulo(@PathVariable String titulo ){
		return ResponseEntity.ok(Repository.findAllBytituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<postagem> post (@RequestBody postagem postagem ){
		return ResponseEntity.status(HttpStatus.CREATED).body(Repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<postagem> put (@RequestBody postagem postagem ){
		return ResponseEntity.status(HttpStatus.OK).body(Repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		Repository.deleteById(id);
	}
	
	
}

