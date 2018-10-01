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

import com.example.demo.entity.Passport;
import com.example.demo.entity.Person;
import com.example.demo.repository.PassportRepository;
import com.example.demo.repository.PersonRepository;

@RestController
public class PassportController {

	@Autowired
	private PassportRepository passportRepository;

	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping("/save/passport/{personId}")
	public ResponseEntity<?> savePassport(@PathVariable(value = "personId") Integer personId,
			@RequestBody Passport passport) {
		Person person = personRepository.getOne(personId);
		passport.setPersonDetails(person);
		passportRepository.save(passport);
		return ResponseEntity.ok("Passport object save with personId------:" + passport);
	}
	
	@GetMapping("/listOfpassport")
	public ResponseEntity<?> getAllPassport() {
		List<Passport> listPassport = passportRepository.findAll();
		return ResponseEntity.ok("List of Passport ----:" + listPassport);
	}
	
	@DeleteMapping("/delete/passport/{passportId}")
	public ResponseEntity<?> deletePassport(@PathVariable(value = "passportId") Integer passportId) {
		Passport passport = passportRepository.getOne(passportId);
		passport.setPersonDetails(null);
		passportRepository.delete(passport);
		return ResponseEntity.ok("The deleted Passport Object ----:" + passportId);
	}
	
	@PutMapping("/update/passport/{passportId}")
	public ResponseEntity<?> updatePassport(@PathVariable(value = "passportId") Integer passportId,
			@RequestBody Passport passport) {
		Passport passportIddd = passportRepository.getOne(passportId);
		passportIddd.setPname(passport.getPname());
		passportIddd.setCountry(passport.getCountry());
		passportRepository.save(passportIddd);
		return ResponseEntity.ok("The updated Passport Object -----::::" + passportIddd);
	}

}
