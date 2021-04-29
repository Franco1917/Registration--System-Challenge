package com.core.inscriptionAplication.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.inscriptionAplication.entity.Subject;


@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
	// public Optional<Subject> findByName(String name);
	 
	
}
