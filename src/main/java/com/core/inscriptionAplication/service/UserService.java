package com.core.inscriptionAplication.service;

import com.core.inscriptionAplication.entity.User;

public interface UserService {

	public Iterable<User>findByEnabled(boolean enabbled);
	
	public Iterable<User>getAllUsers();
}
