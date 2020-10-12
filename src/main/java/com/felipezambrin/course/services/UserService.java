package com.felipezambrin.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipezambrin.course.entities.User;
import com.felipezambrin.course.repositories.UserRepository;

@Service //registra a classe como um componente de serviço e pode ser injetado automaticamente, pode usar o @Component, @Repository, etc
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //findById do JpaRepository retorna um Optional
		return obj.get();
	}
}
