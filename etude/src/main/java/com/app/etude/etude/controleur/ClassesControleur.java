package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.models.Classes;
import com.app.etude.etude.services.ClassesServices;

@RestController
@RequestMapping("/api/Classes")
public class ClassesControleur {
	
	private ClassesServices Classesservices;
	
	@GetMapping("/allClasses")
    public List<Classes> findAllClassess()
	{
		return Classesservices.findAllClasses();
	}
	@GetMapping("/{id}")
    public Classes findClassesbyid(@PathVariable Long id)
	{
		return Classesservices.findClassebyid(id);
	}
	
}
