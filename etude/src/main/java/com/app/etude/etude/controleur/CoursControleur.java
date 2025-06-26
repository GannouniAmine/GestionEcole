package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Cours;
import com.app.etude.etude.services.Coursservices;

@RestController
@RequestMapping("/api/cours")
public class CoursControleur {
	
	private Coursservices coursservices;
	
	@GetMapping("/allcours")
    public List<Cours> findAllCours()
	{
		return coursservices.findAllCours();
	}
	@GetMapping("/{id}")
    public Cours findCoursbyid(@PathVariable Long id)
	{
		return coursservices.findCoursbyid(id);
	}
	
}
