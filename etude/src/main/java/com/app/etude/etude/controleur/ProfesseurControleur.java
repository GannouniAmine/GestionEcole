package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Professeur;
import com.app.etude.etude.services.ProfesseurServices;

@RestController
@RequestMapping("/api/Professeur")
public class ProfesseurControleur {
	
	private ProfesseurServices Professeurservices;
	
	@GetMapping("/allProfesseur")
    public List<Professeur> findAllProfesseurs()
	{
		return Professeurservices.findAllProfesseurs();
	}
	@GetMapping("/{id}")
    public Professeur findProfesseurbyid(@PathVariable Long id)
	{
		return Professeurservices.findProfesseurbyid(id);
	}
	
}
