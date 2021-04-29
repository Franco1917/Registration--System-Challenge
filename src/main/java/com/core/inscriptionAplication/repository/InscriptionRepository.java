package com.core.inscriptionAplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.inscriptionAplication.entity.Inscriptions;



@Repository
public interface InscriptionRepository extends CrudRepository<Inscriptions, Long> {
	 public Optional<Inscriptions> findByStudentName(String studentName);
	 
	 public Iterable<Inscriptions> findByClassName(String name);
}
