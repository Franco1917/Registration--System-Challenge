package com.core.inscriptionAplication.service;

import java.util.List;

import javax.validation.Valid;

import com.core.inscriptionAplication.entity.Subject;


public interface SubjectService {

	public Iterable<Subject>getAllSubject();

	public List <Subject> listAll();

	public Subject createSubject(Subject subject);

	public Subject createSubject1(@Valid Subject subject);
	
	public Subject getSubjectById(Long id) throws Exception ;

	public void deleteSubject(Long id) throws Exception;
}
