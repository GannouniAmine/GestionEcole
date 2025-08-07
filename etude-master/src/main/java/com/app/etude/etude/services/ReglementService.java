package com.app.etude.etude.services;




import java.util.List;

import com.app.etude.etude.dto.ListReglement;
import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.dto.ReglementDto;
import com.app.etude.etude.models.NiveauScolaire;


public interface ReglementService {
    List<ReglementDto> findAllReglements();
    ReglementDto findReglementById(Long reglementId);
    ReglementDto createReglement(ReglementDto reglementDto);
    void deleteReglementById(Long reglementId);


    List<Listeleve> findAllListEleve(NiveauScolaire niveauScolaire);


    List<Listeleve> findAllListElevePaye(NiveauScolaire niveauScolaire);
    List<ListReglement> findlistereglementbyeleve(Long ideleve);
    void deleteEleveById(Long IdEleve);
    
    
}




