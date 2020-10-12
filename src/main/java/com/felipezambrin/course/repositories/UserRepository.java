package com.felipezambrin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipezambrin.course.entities.User;

@Repository //JpaRepository já tem Annotation de Repository, não precisaria colocar
public interface UserRepository extends JpaRepository<User, Long> { 
	
}
