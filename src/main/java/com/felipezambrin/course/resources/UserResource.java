package com.felipezambrin.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipezambrin.course.entities.User;
import com.felipezambrin.course.services.UserService;

@RestController // vai ser um controller
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
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
