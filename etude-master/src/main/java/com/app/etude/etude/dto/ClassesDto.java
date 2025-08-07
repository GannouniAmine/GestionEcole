package com.app.etude.etude.dto;




import lombok.Builder;
import lombok.Data;


import java.util.List;

import com.app.etude.etude.models.Classes;


@Builder
@Data
public class ClassesDto {
    private Long id;
    private String titre;
    private String annescolair;


    private List<Long> elevesIds;


    private List<Long> SeancesIds;
    private List<Long> devoirsIds;
    private List<Long> coursIds;
    private List<Long> examensIds;


    public static Classes toEntity(ClassesDto request)
    {
        return Classes.builder()
                .id(request.getId())
                .titre(request.getTitre())
                .annescolair(request.getAnnescolair())
                .build();


    }
    public static ClassesDto fromEntity(Classes request)
    {
        return ClassesDto.builder()
                .id(request.getId())
                .titre(request.getTitre())
                .annescolair(request.getAnnescolair())
                .build();


    }
}




