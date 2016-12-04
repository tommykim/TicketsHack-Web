package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;

@ManagedBean(name = "mbTheme")
@SessionScoped
public class MBConsultationParTheme implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	@ManagedProperty(value = "#{mbRecherche}")
	private MBRecherche mbRecherche;

	@ManagedProperty(value = "#{mbFiche}")
	private MBFiche mbFiche;
	
	private List<Evenement>listEvenement = new ArrayList<Evenement>();
	
	public List<Evenement> getEvenementsByAllCriteresOrderedByCritere() {
		return listEvenement = facade.getServiceRecherche().findEvenementByAllCriteresOrderedByCritere(
				mbRecherche.getCategorie(), mbRecherche.getTheme(), mbRecherche.getDateDebut(), mbRecherche.getDateFin(), 
				Long.parseLong(mbRecherche.getPrixBas()), Long.parseLong(mbRecherche.getPrixHaut()), mbRecherche.getDepartement(), mbRecherche.getCritereTri());
	}
	
	public String redirectionFiche(Evenement evenement) {
		mbFiche.setEvenement(evenement);
		return "fiche.xhtml?faces-redirect=true";
	}
	
	public MBRecherche getMbRecherche() {
		return mbRecherche;
	}
	public void setMbRecherche(MBRecherche mbRecherche) {
		this.mbRecherche = mbRecherche;
	}
	public MBFiche getMbFiche() {
		return mbFiche;
	}
	public void setMbFiche(MBFiche mbFiche) {
		this.mbFiche = mbFiche;
	}
	
	public Date minDateEvenement (Evenement evenement){
		return facade.getServiceEvenement().findMinDateEvenement(evenement);
	}
	
	public long minPrixEvenement(Evenement evenement){
		return facade.getServiceEvenement().findMinPrixEvenement(evenement);
	}
	
}
