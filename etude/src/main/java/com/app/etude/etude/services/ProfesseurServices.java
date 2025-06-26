package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Professeur;

public interface ProfesseurServices {
	List<Professeur> findAllProfesseurs();
	Professeur findProfesseurbyid(Long id);
	Professeur CreateProfesseur(Professeur a);
	
}
