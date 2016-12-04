package fr.afcepf.al27.ticketshack.implservice.implservice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoDepartement;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoEvenement;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoOccurence;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTarif;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceEvenement;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

@Service
public class ImplServiceEvenement implements IServiceEvenement, Serializable{

	@Autowired
	private IDaoEvenement daoEvenement;


	@Autowired
	private IDaoOccurence daoOccurence;


	@Autowired
	private IDaoDepartement daoDepartement; 
	

	@Autowired
	private IDaoTarif daoTarif; 


	@Override
	public Evenement getEvenementById(int idEvenement) {
		return daoEvenement.findById(idEvenement);
	}

	@Override
	public List<Departement> findDepartementByEvenement(Evenement evenement) {
		return daoDepartement.getDepartementsByEvenement(evenement);
	}

	@Override
	public List<Occurence> findOccurencesByEvenement(Evenement evenement) {
		return daoOccurence.getOccurenceByEvenement(evenement);
	}

	@Override
	public List<Occurence> findOccurencesByEvenementAndDepartement (Evenement evenement,int idDepartement) {
		return daoOccurence.getOccurenceByEvenementAndDep(evenement, idDepartement);
	}

	@Override
	public Date findMinDateEvenement(Evenement evenement) {
		return daoOccurence.getMinDateByEvenement(evenement);
	}

	@Override
	public Date findMaxDateEvenement(Evenement evenement) {
		return daoOccurence.getMaxDateByEvenement(evenement);
	}
	@Override
	public List<Tarif> findTarifsByOccurence(Occurence occurence) {
		return daoTarif.findTarifsByOccurence(occurence);
	}

	@Override
	public Occurence findOccurenceById(int id) {
		return daoOccurence.findById(id);
	}

	@Override
	public List<Tarif> findTarifsByIdOccurence(int idOccurence) {
			return daoTarif.findTarifsByIdOccurence(idOccurence);
	}

	@Override
	public int getNbPlacesRestantesByIdOccurence(int idOccurence) {
		return daoOccurence.getNbPlacesRestantesByIdOccurence(idOccurence);
	}
	
	@Override
	public void enregistrerEvenement(Evenement evenement) {
		daoEvenement.insert(evenement);
	}
	@Override
	public long findMinPrixEvenement(Evenement evenement) {
		return daoEvenement.findMinPrixByEvenement(evenement);
	}
}
