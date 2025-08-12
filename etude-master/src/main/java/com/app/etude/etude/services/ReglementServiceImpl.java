package com.app.etude.etude.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.app.etude.etude.dto.ListReglement;
import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.dto.ReglementDto;
import com.app.etude.etude.models.Eleve;
import com.app.etude.etude.models.NiveauScolaire;
import com.app.etude.etude.models.Parent;
import com.app.etude.etude.models.Reglement;
import com.app.etude.etude.repository.ParentRepository;
import com.app.etude.etude.repository.ReglementRepository;
import com.app.etude.etude.security.repository.EleveRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReglementServiceImpl implements ReglementService {
    private final ReglementRepository reglementRepository;
    private final ParentRepository parentRepository;
    private final EleveRepository eleveRepository;


    @Override
    public List<ListReglement> findAllReglements() {
        return reglementRepository.findAll().stream()
                .map(ListReglement::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public ReglementDto findReglementById(Long reglementId) {
        Optional<Reglement> optionalReglement = reglementRepository.findById(reglementId);
        optionalReglement.orElseThrow(() -> new RuntimeException("Reglement not found with id: " + reglementId));
        return ReglementDto.fromEntity(optionalReglement.get());
    }


    @Override
    public ReglementDto createReglement(ReglementDto reglementDto) {
        Parent parent = parentRepository.findById(reglementDto.getParentId())
                .orElseThrow(() -> new EntityNotFoundException("No Parent found with ID:: " + reglementDto.getParentId()));


        Eleve eleve = eleveRepository.findById(reglementDto.getEleveId())
                .orElseThrow(() -> new EntityNotFoundException("No Eleve found with ID:: " + reglementDto.getEleveId()));


        Reglement reglement = ReglementDto.toEntity(reglementDto);
        reglement.setEleve(eleve);
        reglement.setParent(parent);
        eleve.setStatutPaiement("paye");
        eleveRepository.save(eleve);
        return ReglementDto.fromEntity(reglementRepository.save(reglement));
    }


    @Override
    public void deleteReglementById(Long reglementId) {
        reglementRepository.deleteById(reglementId);
    }


    @Override
    public List<Listeleve> findAllListEleve(NiveauScolaire niveauScolaire) {
        return eleveRepository.listAllEleveByNiv(niveauScolaire).stream()
                .map(Listeleve::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<Listeleve> findAllListElevePaye(NiveauScolaire niveauScolaire) {
        return eleveRepository.listAllEleveByNivAndPaye(niveauScolaire).stream()
                .map(Listeleve::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteEleveById(Long IdEleve) {
        eleveRepository.deleteById(IdEleve);
    }


	@Override
	public List<ListReglement> findlistereglementbyeleve(Long ideleve) {
		   return reglementRepository.findByEleve_Id(ideleve).stream()
	                .map(ListReglement::fromEntity)
	                .collect(Collectors.toList());
	}


}




