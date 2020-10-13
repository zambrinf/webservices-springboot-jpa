package com.felipezambrin.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipezambrin.course.entities.Product;
import com.felipezambrin.course.repositories.ProductRepository;

@Service //registra a classe como um componente de serviço e pode ser injetado automaticamente, pode usar o @Component, @Repository, etc
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); //findById do JpaRepository retorna um Optional
		return obj.get();
	}
}
