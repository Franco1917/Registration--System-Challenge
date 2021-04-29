package com.core.inscriptionAplication.serviceimpl;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.inscriptionAplication.entity.Inscriptions;
import com.core.inscriptionAplication.repository.InscriptionRepository;
import com.core.inscriptionAplication.service.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService {

	@Autowired
	InscriptionRepository inscriptionsrepository;
	@Override
	public Inscriptions createInscription(@Valid Inscriptions inscriptions) {
	inscriptions= inscriptionsrepository.save(inscriptions);
		
		return inscriptions;
	}
	@Override
	public Iterable<Inscriptions> getByname(String name) {
		
		return inscriptionsrepository.findByClassName(name);
	}
	
	
	
	

}
