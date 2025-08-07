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
    private Elevedto eleve;






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
                .eleve(Elevedto.fromEntity(request.getEleve()))
                        .build();


    }
}




