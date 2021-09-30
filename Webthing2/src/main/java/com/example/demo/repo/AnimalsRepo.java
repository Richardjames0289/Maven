package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Animals;

	@Repository
	public interface AnimalsRepo extends JpaRepository< Animals , Long> {
		
		@Query(value = "SELECT * FROM Animals Where first_name = ?1", nativeQuery = true)
		List<Animals>findByname(String name);
		
	}


