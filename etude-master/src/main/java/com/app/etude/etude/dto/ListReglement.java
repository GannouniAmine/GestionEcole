package com.app.etude.etude.dto;


import lombok.*;


import java.util.Date;

import com.app.etude.etude.models.Reglement;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListReglement {
    private Long id;
    private String modePaiement;
    private Date operation;
    private Double montant;
    private String nomeleve;
    private String nomparent;
    
    public static Reglement toEntity(ListReglement request)
    {


        return  Reglement.builder()
                .id(request.getId())
                .modepaiement(request.getModePaiement())
                .operation(request.getOperation())
                .montant(request.getMontant())
                .build();
    }
    public static ListReglement fromEntity(Reglement request)
    {
        return ListReglement.builder()
                .id(request.getId())
                .modePaiement(request.getModepaiement())
                .operation(request.getOperation())
                .montant(request.getMontant())
                .nomeleve(Elevedto.fromEntity(request.getEleve()).getFirstName() + Elevedto.fromEntity(request.getEleve()).getLastName())
        		.nomparent(Parentdto.fromEntity(request.getParent()).getFirstName() + Parentdto.fromEntity(request.getParent()).getLastName())
        		.build();


    }
}




