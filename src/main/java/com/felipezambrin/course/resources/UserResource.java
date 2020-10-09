package com.felipezambrin.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipezambrin.course.entities.User;

@RestController // vai ser um controller
@RequestMapping(value="/users") // nome do recurso
public class UserResource {
	
	@GetMapping //responde à requisição GET do HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u); // ok() retorna um BodyBuilder e .body() seta o corpo desse BodyBuilder, retornando-o
	}
	
	
	
}
