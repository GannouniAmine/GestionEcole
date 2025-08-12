package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.services.ClassesServices;
import com.app.etude.etude.services.EleveServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/Eleve")
@RequiredArgsConstructor
public class EleveControleur {
	
	private final EleveServices Eleveservices;
	
	@GetMapping("/{id}")
    public Eleve findElevebyid(@PathVariable Long id)
	{
		return Eleveservices.findElevebyid(id);
	}
	
	@GetMapping("/listalleleveByClasse/{idclasse}")
	   public List<Listeleve> listeleveByClasse (@PathVariable("idclasse") Long idclasse) {
	       // TODO Auto-generated method stub
	       return Eleveservices.listAllEleveByClasses(idclasse);
	   }

	@GetMapping("/listalleleveByParentId")
	   public List<Listeleve> listeleveByParentId (Authentication connectedUser) {
	       // TODO Auto-generated method stub
	       return Eleveservices.listAllEleveByParentId(connectedUser);
	   }
	
	@GetMapping("/listalleleve")
	   public List<Listeleve> listeleve() {
	       // TODO Auto-generated method stub
	       return Eleveservices.listAllEleve();
	}
	
	
}
