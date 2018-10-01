package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private DoctorRepository doctorRepo;

	@RequestMapping("/savepatient")
	public ResponseEntity<?> savePatient(@RequestBody Patient patient) {

		Patient patdata = patientRepo.save(patient);
		return ResponseEntity.ok("" + patdata);

	}

	@RequestMapping("/savePatientWithDoctorId/{doctorId}")
	public ResponseEntity<?> connectPatientWithDoctor(@PathVariable(value = "doctorId") Integer doctorId,
			@RequestBody Patient patient) {
		System.out.println("enter the connectPatientWithDoctor");
		Doctor doc = doctorRepo.getOne(doctorId);
		System.out.println("DOCTOR OBJECT ---:" + doc);
		Set<Doctor> set = new HashSet<Doctor>();
		set.add(doc);
		System.out.println("put into a collection " + set);
		patient.setDoctors(set);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		Patient pat1 = patientRepo.save(patient);
		return ResponseEntity.ok("the patient contain the patid with doctor----" + pat1);

	}

	@RequestMapping("/delete/patient/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable(value = "patientId") Integer patientId) {
		/*
		 * return patientRepo.findById(patientId).map(patient->{
		 * patient.setDoctors(null); patientRepo.delete(patient);
		 * ResponseEntity.ok(""+patientId);
		 * 
		 * });
		 */
		Patient pat = patientRepo.getOne(patientId);
		pat.setDoctors(null);
		patientRepo.delete(pat);
		return ResponseEntity.ok("patient delted with patId" + patientId + "patient Objet " + pat);
	}

	@RequestMapping("/getAllPatient")
	public ResponseEntity<?> getAllPatient() {
		List<Patient> listPatient = patientRepo.findAll();
		return ResponseEntity.ok("get ALL Patient Object -----:" + listPatient);
	}

	@RequestMapping("/update/patient/{patientId}")
	public ResponseEntity<?> updatePatient(@PathVariable(value = "patientId") Integer patientId,
			@RequestBody Patient patient) {
		Patient pat = patientRepo.getOne(patientId);
		pat.setName(pat.getName());
		pat.setAge(pat.getAge());
		patientRepo.save(pat);
		return ResponseEntity.ok("The Patient object is Object with PatientId -----------:" + patientId);
	}

}
