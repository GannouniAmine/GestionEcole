package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Matiere;
import com.app.etude.etude.services.MatiereServices;

@RestController
@RequestMapping("/api/Matiere")
public class MatiereControleur {
	
	private MatiereServices Matiereservices;
	
	@GetMapping("/allMatiere")
    public List<Matiere> findAllMatieres()
	{
		return Matiereservices.findAllMatieres();
	}
	@GetMapping("/{id}")
    public Matiere findMatierebyid(@PathVariable Long id)
	{
		return Matiereservices.findMatierebyid(id);
	}
	
}
