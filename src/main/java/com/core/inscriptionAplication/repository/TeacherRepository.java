package com.core.inscriptionAplication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.inscriptionAplication.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	public Optional<Teacher> findByName(String name);
}
