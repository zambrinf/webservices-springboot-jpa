package com.felipezambrin.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipezambrin.course.entities.User;
import com.felipezambrin.course.repositories.UserRepository;
import com.felipezambrin.course.services.exceptions.ResourceNotFoundException;

@Service //registra a classe como um componente de serviço e pode ser injetado automaticamente, pode usar o @Component, @Repository, etc
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id); //findById do JpaRepository retorna um Optional
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // getOne só deixa um objeto monitorado pelo JPA para depois fazer uma operação no DB, mais eficiente do que o findById
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		// não colocar Id e Senha para não permitir essa alteração
	}
}
