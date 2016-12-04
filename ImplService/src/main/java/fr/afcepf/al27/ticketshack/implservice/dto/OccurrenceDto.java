package fr.afcepf.al27.ticketshack.implservice.dto;

import java.io.Serializable;

public class OccurrenceDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int nbPlace;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public OccurrenceDto(int id, int nbPlace) {
		super();
		this.id = id;
		this.nbPlace = nbPlace;
	}
	public OccurrenceDto() {
		super();
	}
	
}
