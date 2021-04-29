package com.core.inscriptionAplication.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.inscriptionAplication.entity.Subject;
import com.core.inscriptionAplication.entity.Teacher;
import com.core.inscriptionAplication.repository.TeacherRepository;
import com.core.inscriptionAplication.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	@Override
	public Iterable<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}
	@Override
	public Teacher createSubject1(@Valid Teacher teacher) {
		// TODO Auto-generated method stub
		teacher= teacherRepository.save(teacher);
		
		return teacher;
	}
	@Override
	public Teacher getTeacherById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return  teacherRepository.findById(id).orElseThrow(() -> new Exception("User  not exist"));
	}
	@Override
	public void deleteTeacher(Long id) throws Exception {
		Teacher teacher=getTeacherById(id);
		teacherRepository.delete(teacher);
		
		
		
	}

	
}
