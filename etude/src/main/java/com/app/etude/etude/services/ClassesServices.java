package com.app.etude.etude.services;

import java.util.List;
import com.app.etude.etude.models.Classes;

public interface ClassesServices {
	
	List<Classes> findAllClasses();
	Classes findClassebyid(Long id);
	Classes CreateClasse(Classes a);
	
}
