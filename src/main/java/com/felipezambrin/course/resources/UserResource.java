package com.felipezambrin.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipezambrin.course.entities.User;
import com.felipezambrin.course.services.UserService;

@RestController // vai ser um rest controller 
@RequestMapping(value="/users") // nome do recurso
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping //endpoint que responde à requisição GET do HTTP
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // ok() retorna um BodyBuilder e .body() seta o corpo desse BodyBuilder, retornando-o
	}
	
	
	@GetMapping(value = "/{id}") // isso indica que a requisição vai aceitar um id na url
	public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable para ele pegar o id do caminho da requisição
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { //@RequestBody para pegar o corpo da requisição com um Json
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // para fazer o código 201 e tambem retornar o endereço do objeto
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna o código 204
	}
}
