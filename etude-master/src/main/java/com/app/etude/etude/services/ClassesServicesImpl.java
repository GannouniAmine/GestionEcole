package com.app.etude.etude.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.etude.etude.dto.ClassesDto;
import com.app.etude.etude.dto.Labelvalueclasse;
import com.app.etude.etude.models.Classes;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.repository.Classesrepository;
import com.app.etude.etude.security.repository.EleveRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ClassesServicesImpl implements ClassesServices {


    private final Classesrepository classesRepository;
    private final EleveRepository  eleverepository;

    @Override
    public List<ClassesDto> findAllClasses() {
        List<Classes> classesList = classesRepository.findAll();
        return classesList.stream()
                          .map(ClassesDto::fromEntity)
                          .collect(Collectors.toList());
    }

    @Override
    public ClassesDto findClassebyid(Long id) {
        Classes c = classesRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Classe non trouvée avec id: " + id));
        return ClassesDto.fromEntity(c);
    }

    @Override
    public ClassesDto CreateClasse(ClassesDto classeDto) {
    	Classes classes = ClassesDto.toEntity(classeDto);
        Classes saved = classesRepository.save(classes);
        return ClassesDto.fromEntity(saved);
    }

    @Override
    public void DeleteById(Long id) {
        if (!classesRepository.existsById(id)) {
            throw new RuntimeException("Classe introuvable avec id: " + id);
        }
        classesRepository.deleteById(id);
    }

	@Override
	public ClassesDto UpdateClasse(ClassesDto a) {
		// TODO Auto-generated method stub
		 Classes classe = classesRepository.findById(a.getId())
                 .orElseThrow(() -> new RuntimeException("Classe non trouvée avec id: " + a.getId()));
		 
		 classe.setTitre(a.getTitre());
		 classe.setAnnescolair(a.getAnnescolair());
		 Classes classsaved = classesRepository.save(classe);
		return ClassesDto.fromEntity(classsaved);
	}
	
	@Override
	public List<Labelvalueclasse> listeclasse() {
	       return classesRepository.findAll()
	               .stream()
	               .map(Labelvalueclasse::fromEntity)
	               .collect(Collectors.toList());
	   }
	
	 @Override
	   public void Ajoutereleveauclasse(Long idclasse, Long ideleve) {
	       Optional<Classes> clssoptional = classesRepository.findById(idclasse);
	       Optional<Eleve> eleveOptional = eleverepository.findById(ideleve);
	       if (eleveOptional.isPresent() && clssoptional.isPresent() ) {
	           eleveOptional.get().setClasse(clssoptional.get());
	           eleveOptional.get().setStatutAffectation("affecte");
	           eleverepository.save(eleveOptional.get());
	         System.err.println(eleveOptional.get().getStatutAffectation());
	       }}

	 



}
