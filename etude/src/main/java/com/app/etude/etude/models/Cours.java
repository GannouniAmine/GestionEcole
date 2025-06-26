
package com.app.etude.etude.models;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cours")
@AllArgsConstructor //contructeur parametrer
@NoArgsConstructor //constructeur par default
@Setter 
@Getter
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long salle;
    private Date dateCours;
    private Time heureDebut;
    private Time heureFin;


}
