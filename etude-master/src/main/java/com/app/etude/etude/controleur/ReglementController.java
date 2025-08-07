package com.app.etude.etude.controleur;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.app.etude.etude.dto.ListReglement;
import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.dto.ReglementDto;
import com.app.etude.etude.models.NiveauScolaire;
import com.app.etude.etude.services.ReglementService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reglements")
@RequiredArgsConstructor
public class ReglementController {




    private final ReglementService reglementService;


    @GetMapping("/lister")
    public List<ReglementDto> findAllReglements() {
        return reglementService.findAllReglements();
    }


    @GetMapping("findById/{id}")
    public ReglementDto findReglementById(@PathVariable Long id) {
        return reglementService.findReglementById(id);
    }


    @PostMapping("/save")
    public ReglementDto createReglement(@RequestBody ReglementDto reglementDto) {
        return reglementService.createReglement(reglementDto);
    }


    @DeleteMapping("delete/{id}")
    public void deleteReglementById(@PathVariable Long id) {
        reglementService.deleteReglementById(id);
    }


    @GetMapping("/findallEleveByniveau/{niveauScolaire}")
    public List<Listeleve> getAllStudenByNiveau(@PathVariable("niveauScolaire") NiveauScolaire niveauScolaire) {
        return reglementService.findAllListEleve(niveauScolaire);
    }
    @GetMapping("/findallEleveByniveaupaye/{niveauScolaire}")
    public List<Listeleve> getAllStudenByNiveaupaye(@PathVariable("niveauScolaire") NiveauScolaire niveauScolaire) {
        return reglementService.findAllListEleve(niveauScolaire);
    }
    @DeleteMapping("deleteEleve/{id}")
    public void deleteEleveById(@PathVariable Long id) {reglementService.deleteEleveById(id);
    }
    @GetMapping("/findallEleveByniveaupayeAffecte/{niveauScolaire}")
    public List<Listeleve> getAllStudenByNiveaupayee(@PathVariable("niveauScolaire") NiveauScolaire niveauScolaire) {
        return reglementService.findAllListElevePaye(niveauScolaire);
    }
    @GetMapping("/findallreglementbyeleve/{ideleve}")
    public List<ListReglement> getAllreglementbyeleve(@PathVariable("ideleve") Long ideleve) {
        return reglementService.findlistereglementbyeleve(ideleve);
    }


}




