package com.core.inscriptionAplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.inscriptionAplication.entity.User;
import com.core.inscriptionAplication.repository.UserRepository;
import com.core.inscriptionAplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepositiry;
	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepositiry.findAll();
	}
	@Override
	public Iterable<User> findByEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

}
