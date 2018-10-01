package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	
	@Query("SELECT p.passportNo,p.pname,p.country,pa.aadharNo,pa.pname,pa.age FROM Passport p inner join p.personDetails pa")
	List<Object[]> findByJoinQueryPersonPassport();

}
