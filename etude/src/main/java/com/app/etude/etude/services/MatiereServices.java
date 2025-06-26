package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.models.Matiere;

public interface MatiereServices {
	List<Matiere> findAllMatieres();
	Matiere findMatierebyid(Long id);
	
	Matiere CreateMatiere(Matiere a);
	
}
