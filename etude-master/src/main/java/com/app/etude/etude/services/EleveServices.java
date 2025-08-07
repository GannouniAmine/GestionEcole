package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.NiveauScolaire;

public interface EleveServices {
	List<Eleve> findAllEleves();
	Eleve findElevebyid(Long id);
	
	Eleve CreateEleve(Eleve e);
	List<Listeleve> listAllEleveByNivAndPaye(NiveauScolaire niveauScolaire);
	List<Listeleve> listAllEleveByClasses(Long idclasse);
}
