package com.app.etude.etude.services;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.NiveauScolaire;

public interface EleveServices {
	Eleve findElevebyid(Long id);
	
	Eleve CreateEleve(Eleve e);
	List<Listeleve> listAllEleveByNivAndPaye(NiveauScolaire niveauScolaire);
	List<Listeleve> listAllEleveByClasses(Long idclasse);
	
	List<Listeleve> listAllEleveByParentId(Authentication connectedUser);
	List<Listeleve> listAllEleve();
}
