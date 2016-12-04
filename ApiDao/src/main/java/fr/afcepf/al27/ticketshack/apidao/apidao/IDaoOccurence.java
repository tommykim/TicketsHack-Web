package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.Date;
import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

public interface IDaoOccurence {
	
	public void insert(Occurence occurence);
	public void update(Occurence occurence);
	public Occurence findById(int idOccurence);
	public List<Occurence> findAll();
	public void delete(Occurence occurence);
	public List<Occurence> getOccurenceByEvenementAndDep(Evenement evenement, Departement departement);//A VOIR SI NECESSAIRE
	Date getMinDateByEvenement(Evenement evenement);
	Date getMaxDateByEvenement(Evenement evenement);
	List<Occurence> getOccurenceByEvenement(Evenement evenement);
	List<Occurence> getOccurencesByUtilisateur(Utilisateur utilisateur);
	Occurence getOccurenceByTarif(Tarif tarif);
	public List<Occurence> getOccurenceByEvenementAndDep(Evenement evenement,int idDepartement);
	String getLibelleEvenement(Occurence occurence);
	int getNbPlacesRestantesByIdOccurence(int idOccurence);
	
	
}
