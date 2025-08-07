package com.app.etude.etude.dto;




import lombok.Builder;
import lombok.Data;


import java.util.Date;

import com.app.etude.etude.models.Reglement;


@Builder
@Data
public class ReglementDto {
    private Long id;
    private String modepaiement;
    private Date operation;
    private Double montant;
    private Long parentId;
    private Long eleveId;


    public static Reglement toEntity(ReglementDto request)
    {
        return Reglement.builder()
                .id(request.getId())
                .modepaiement(request.getModepaiement())
                .operation(request.getOperation())
                .montant(request.getMontant())
                .build();


    }
    public static ReglementDto fromEntity(Reglement request)
    {
        return ReglementDto.builder()
                .id(request.getId())
                .modepaiement(request.getModepaiement())
                .operation(request.getOperation())
                .montant(request.getMontant())
                .build();
    }
}




