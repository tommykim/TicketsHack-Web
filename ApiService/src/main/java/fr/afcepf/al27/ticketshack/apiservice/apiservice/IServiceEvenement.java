package fr.afcepf.al27.ticketshack.apiservice.apiservice;

import java.util.Date;
import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;


public interface IServiceEvenement {

	Evenement getEvenementById(int idEvenement);
	List<Departement> findDepartementByEvenement(Evenement evenement);
	List<Occurence> findOccurencesByEvenement(Evenement evenement);
	List<Occurence> findOccurencesByEvenementAndDepartement(Evenement evenement, int idDepartement);
	Date findMinDateEvenement(Evenement evenement);
	Date findMaxDateEvenement(Evenement evenement);
	List<Tarif> findTarifsByOccurence(Occurence occurence);
	List<Tarif> findTarifsByIdOccurence(int idOccurence);
	Occurence findOccurenceById(int id); 
	int getNbPlacesRestantesByIdOccurence(int idOccurence);
	void enregistrerEvenement(Evenement evenement);
	long findMinPrixEvenement(Evenement evenement);
}
