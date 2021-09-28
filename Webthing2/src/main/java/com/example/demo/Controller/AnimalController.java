package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Animals;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	List<Animals> animalsList = new ArrayList<>();
	@GetMapping("/hiro")
	public String helloWorld() {
		return "heru is great";
	}
	
	@GetMapping("/hyroo")
	public Animals getanimal() {
		return new Animals("Heeriu", "Heeriuson");
				
	}
	@GetMapping("/getAll")
	public List<Animals> getAnimals() {
		  return animalsList;
				
	}
	
	
	@PostMapping("/createStatic") 
		public Animals createStatic(@RequestBody Animals a) {
		return new Animals(a.getFirstname(),a.getLastname());
	}
	@PostMapping("/create")
	public ResponseEntity<Animals> create(@RequestBody Animals a) {
		return this.animalsList.add(a) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(".delete/{id}")
	public ResponseEntity<Boolean> deleteAnimals(@PathVariable long id) {
		return this.animalsList.remove(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR)
				;
	}
	@GetMapping("/readAll")
	public ResponseEntity<List<Animals>> readAll() {
		return ResponseEntity.ok(this.animalsList);
	}
	
	}

	
		
	
