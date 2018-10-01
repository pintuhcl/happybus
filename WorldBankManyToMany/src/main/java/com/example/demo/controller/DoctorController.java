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
public class DoctorController {

	@Autowired
	private DoctorRepository doctorrepo;

	@Autowired
	private PatientRepository patientrepo;

	@RequestMapping("/saveDoctor")
	public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor) {
		Doctor doct = doctorrepo.save(doctor);
		return ResponseEntity.ok("doctor data saved ---:" + doct);
	}

	@RequestMapping("/savDoctorWithpatientId/{patientId}")
	public ResponseEntity<?> connectDoctorWithPatient(@PathVariable(value = "patientId") Integer patientId,
			@RequestBody Doctor doctor) {
		Patient pat = patientrepo.getOne(patientId);
		Set<Patient> set = new HashSet<Patient>();
		set.add(pat);
		doctor.setPatients(set);
		Doctor doc1 = doctorrepo.save(doctor);
		return ResponseEntity.ok("The doctor contain the docid with patient--------------:" + doc1);

	}

	@RequestMapping("/delete/doctor/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable(value = "doctorId") Integer doctorId) {
		Doctor doc = doctorrepo.getOne(doctorId);
		doctorrepo.delete(doc);
		return ResponseEntity.ok("doctor deleted with doctorId and Associated Object--------::::" + doctorId);
	}

	@RequestMapping("/getAllDoctor")
	public ResponseEntity<?> getListDoctor() {
		List<Doctor> listDoc = doctorrepo.findAll();
		return ResponseEntity.ok("list of Doctor ----:" + listDoc);
	}

	@RequestMapping("/update/doctor/{docId}")
	public ResponseEntity<?> updateDoctor(@PathVariable(value = "docId") Integer docId, @RequestBody Doctor doctor) {
		Doctor doc = doctorrepo.getOne(docId);
		doc.setName(doc.getName());
		doc.setSpecialization(doc.getSpecialization());
		doctorrepo.save(doc);
		return ResponseEntity.ok("The doctor object is updated with DocId-----:::" + docId);
	}
}
