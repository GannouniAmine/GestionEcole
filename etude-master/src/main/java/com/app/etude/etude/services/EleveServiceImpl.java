package com.app.etude.etude.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.NiveauScolaire;
import com.app.etude.etude.models.Parent;
import com.app.etude.etude.repository.Classesrepository;
import com.app.etude.etude.security.repository.EleveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EleveServiceImpl implements EleveServices {
	private final EleveRepository eleverepository ;

	@Override
	public Eleve findElevebyid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve CreateEleve(Eleve e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	   public List<Listeleve> listAllEleveByNivAndPaye(NiveauScolaire niveauScolaire) {
	       return eleverepository.listAllEleveByNiv(niveauScolaire).stream()
	               .map(Listeleve::fromEntity)
	               .collect(Collectors.toList());
	   }
	   @Override
	   public List<Listeleve> listAllEleveByClasses(Long idclasse) {
	       return eleverepository.listAllEleveByClasse(idclasse).stream()
	               .map(Listeleve::fromEntity)
	               .collect(Collectors.toList());
	   }

	   @Override
	   public List<Listeleve> listAllEleveByParentId(Authentication connectedUser) {
		Parent parent = ((Parent) connectedUser.getPrincipal());
		List<Eleve> eleves = eleverepository.listEleveByParent(parent.getId());
		return eleves.stream()
				.map(Listeleve::fromEntity)
				.collect(Collectors.toList());
	   }
	   @Override
	   public List<Listeleve> listAllEleve() {
		List<Eleve> eleves = eleverepository.findAll();
		return eleves.stream()
				.map(Listeleve::fromEntity)
				.collect(Collectors.toList());
	   }

}
