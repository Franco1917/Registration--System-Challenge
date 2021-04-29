package com.core.inscriptionAplication.service;

import javax.validation.Valid;


import com.core.inscriptionAplication.entity.Teacher;


public interface TeacherService {

	public Iterable<Teacher>getAllTeacher();
	

	public Teacher createSubject1(@Valid Teacher teacher);
	
	public Teacher getTeacherById(Long id) throws Exception ;

	public void deleteTeacher(Long id) throws Exception;
}
