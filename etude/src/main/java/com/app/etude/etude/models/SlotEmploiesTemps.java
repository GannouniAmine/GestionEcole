package com.app.etude.etude.models;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="slotemploiestemps")
public class SlotEmploiesTemps {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Génère les ID automatiquement
	private long id ;
	@Column
	private String jour;
	private Time heuredebut;
	private Time heurefin;
	
	
	
	public SlotEmploiesTemps() {}
	public SlotEmploiesTemps(long id, String jour, Time heuredebut, Time heurefin) {
		super();
		this.id = id;
		this.jour = jour;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public Time getHeuredebut() {
		return heuredebut;
	}
	public void setHeuredebut(Time heuredebut) {
		this.heuredebut = heuredebut;
	}
	public Time getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(Time heurefin) {
		this.heurefin = heurefin;
	}
}

