package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AnimalsDTO;
import com.example.demo.Domain.Animals;
import com.example.demo.Service.AnimalsService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

@Autowired
private AnimalsService service;

//create
@PostMapping("/create")
public ResponseEntity<AnimalsDTO> create(@RequestBody AnimalsDTO a) {
	return new ResponseEntity <AnimalsDTO> (this.service.create(a),HttpStatus.CREATED);
}
//Read
@GetMapping("/Read")
public ResponseEntity<List<Animals>> readAll() {
	return new ResponseEntity <List<Animals>>(this.service.readAll(),HttpStatus.OK);
	
}

//Readid
@GetMapping("/read/{id}")
public ResponseEntity<Animals> read(@PathVariable long id) {
	return new ResponseEntity <Animals>(this.service.read(id),HttpStatus.OK);
	
}

//Update
@PutMapping("/update/{id}")
public ResponseEntity<Animals> update(@PathVariable long id, @RequestBody Animals a) { 
return new ResponseEntity<Animals>(this.service.update(a, id), HttpStatus.ACCEPTED);

}
//delete
@DeleteMapping("/delete/{id}")
public ResponseEntity<Boolean> delete(@PathVariable long id) {
	return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
}
//Findbyname

@GetMapping("/readname/{name}")
public ResponseEntity <List<Animals>>findByName (@PathVariable String name) {
	return new ResponseEntity <List<Animals>>(this.service.findByName(name), HttpStatus.OK);
	
}
}

	

	
		
	
