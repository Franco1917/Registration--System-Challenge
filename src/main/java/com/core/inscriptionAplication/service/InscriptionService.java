package com.core.inscriptionAplication.service;


import javax.validation.Valid;

import com.core.inscriptionAplication.entity.Inscriptions;



public interface InscriptionService  {

	public Inscriptions createInscription(@Valid Inscriptions inscriptions);
	
	public Iterable<Inscriptions>getByname(String name);
	
	
}

