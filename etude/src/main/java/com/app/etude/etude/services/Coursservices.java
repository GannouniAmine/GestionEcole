package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Cours;

public interface Coursservices {
	List<Cours> findAllCours();
	Cours findCoursbyid(Long id);
	
	Cours CreateCours(Cours c);
	
}
