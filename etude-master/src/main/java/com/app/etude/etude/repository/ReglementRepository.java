package com.app.etude.etude.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.etude.etude.models.Reglement;

import java.util.List;


public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    List<Reglement> findByParent_Id(Long parentId);
    List<Reglement> findByEleve_Id(Long eleveId);
}




