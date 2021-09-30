package com.example.demo.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AnimalsDTO;
import com.example.demo.Domain.Animals;
import com.example.demo.Exceptions.AnimalsNotFoundException;
import com.example.demo.repo.AnimalsRepo;

@Service
public class AnimalsService {
	
	private ModelMapper mapper;
	private AnimalsRepo repo;
	
@Autowired 
public AnimalsService(AnimalsRepo repo, ModelMapper mapper) {
	this.repo = repo;
	this.mapper = mapper;
}
public AnimalsDTO mapToDTO(Animals a) {
	return this.mapper.map(a,  AnimalsDTO.class);
	
}
public Animals mapFromDTO(AnimalsDTO a) {
	return this.mapper.map(a,  Animals.class);
}

public AnimalsService (AnimalsRepo repo) {
	this.repo = repo;
}

//create 
public AnimalsDTO create(AnimalsDTO a) {
	Animals saveIt = this.mapFromDTO(a);
	Animals saved = this.repo.save(saveIt);
	return this.mapToDTO(saved);
}

//ReadAll

public List<Animals> readAll() {
	return this.repo.findAll();
}
	
//Read id

public Animals read(long id) {
	return this.repo.findById(id).get();
}

//update 
public Animals update(Animals a, long id) {
	Animals exists = this.repo.findById(id).orElseThrow(AnimalsNotFoundException :: new);
	exists.setFirstname(a.getFirstname());
	exists.setLastname(a.getFirstname());
	return this.repo.saveAndFlush(exists);
	
}
//delete
public boolean delete(long id) {
	if (!this.repo.existsById(id)) {
		throw new AnimalsNotFoundException();
	}
	this.repo.deleteById(id);
	return !this.repo.existsById(id);
}
//Findbyname
public List<Animals> findByName(String name) {
	return this.repo.findByname(name);
}

}
