package com.app.etude.etude.models;


import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
    private Long idNote;
	private String noteExam;
	private String remarque;
	@ManyToOne(fetch = FetchType.LAZY)
	private Eleve eleve;
	@ManyToOne(fetch = FetchType.LAZY)
	private Examen examen;


}






