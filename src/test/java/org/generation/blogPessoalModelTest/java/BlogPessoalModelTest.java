package org.generation.blogPessoalModelTest.java;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.AssertTrue;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BlogPessoalModelTest {
	
	public Usuario usuario;
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	public void star() {
		usuario = new Usuario (1L, "jordan", "GoatJordan", "123456");

}
	@Test
	public void testValidationAtributos() {
		
		usuario.setNome("Jason");
		usuario.setUsuario("jaycrack");
		usuario.setSenha("1234567");
		
		Set<ConstraintViolation<Usuario>> violations =validator.validate(usuario);
		
		System.out.println(violations.toString());
		
		
		
	}
}