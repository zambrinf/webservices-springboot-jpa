package com.felipezambrin.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipezambrin.course.entities.Category;
import com.felipezambrin.course.repositories.CategoryRepository;

@Service //registra a classe como um componente de serviço e pode ser injetado automaticamente, pode usar o @Component, @Repository, etc
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //findById do JpaRepository retorna um Optional
		return obj.get();
	}
}
