package com.app.etude.etude.services;


import org.springframework.security.core.Authentication;

import com.app.etude.etude.dto.ListNoteDto;
import com.app.etude.etude.dto.Listeleve;
import com.app.etude.etude.dto.Listparent;
import com.app.etude.etude.models.Parent;

import java.util.List;


public interface ParentService {
   List<Listparent> findAllParents();
   void ajouterEleveAuParent(String email, Authentication connectedUser);
   Parent getParentByEleveId(Long eleveId);


   List<Listeleve> findAllEleveByParentId( Authentication connectedUser);

    // Nouvelle méthode pour récupérer les notes par parent et matière
//    List<ListNoteDto> getListNotesByParentAndMatiere(Long idMatiere, Authentication connectedUser);


    List<ListNoteDto> getListNotesByEleveAndMatiere(Long idEleve, Long idMatiere, Authentication connectedUser);
}




