package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PassportRepository;
import com.example.demo.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PassportRepository passportRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@PostMapping("/person/save")
	public ResponseEntity<?> savePerson(@RequestBody Person person) {
		Person perId = personRepository.save(person);
		return ResponseEntity.ok("The Person Object with PersonId ----::::" + perId);
	}
	
	@GetMapping("/listOfPerson")
	public ResponseEntity<?> getAllPerson() {
		List<Person> listPerson = personRepository.findAll();
		return ResponseEntity.ok("ALL person object -----:::" + listPerson);
	}
	
	
	@DeleteMapping("/person/delete/{personId}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "personId") Integer personId) {
		Person person = personRepository.getOne(personId);
		personRepository.delete(person);
		return ResponseEntity.ok("The deleted Object is ----:" + personId);

	}
	
	
	@PutMapping("/person/update/{personId}")
	public ResponseEntity<?> updatePerson(@PathVariable (value="personId") Integer personId, @RequestBody Person person)
	{
		Person per=personRepository.getOne(personId);
		per.setPname(person.getPname());
		per.setAge(person.getAge());
		personRepository.save(per);
		return ResponseEntity.ok(""+per);
	}
	
	
	@GetMapping("/innerjoin/person/passport")
	public ResponseEntity<?> getObjectArrayByJoiningPersonPassport()
	{
		List<Object[]> listObj=personRepository.findByJoinQueryPersonPassport();
		return ResponseEntity.ok("After Joining passport and person we Get List of Object[] -----::::"+listObj);
	}

}
