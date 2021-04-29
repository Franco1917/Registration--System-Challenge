package com.core.inscriptionAplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.inscriptionAplication.entity.Subject;
import com.core.inscriptionAplication.repository.SubjectRepository;
import com.core.inscriptionAplication.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subjectrepository;

	@Override
	public Iterable<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectrepository.findAll();
	}

	@Override
	public List<Subject> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject createSubject(Subject subject) {
		// TODO Auto-generated method stub
		subject = subjectrepository.save(subject);
		return subject;
	}

	@Override
	public Subject createSubject1(@Valid Subject subject) {
		subject= subjectrepository.save(subject);
		return subject;
	}

	@Override
	public Subject getSubjectById(Long id) throws Exception {
		
		return subjectrepository.findById(id).orElseThrow(() -> new Exception("User  not exist"));
	}

	@Override
	public void deleteSubject(Long id) throws Exception {
	 Subject subject = getSubjectById(id);
		subjectrepository.delete(subject);
	}

	
}
