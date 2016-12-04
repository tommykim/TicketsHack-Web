package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

@ManagedBean(name = "mbCategorie")
@SessionScoped
public class MBConsultationParCategorie  implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	private Date minDateDebut = new Date();
	private Date minDateFin = new Date();
	
	@ManagedProperty(value = "#{mbRecherche}")
	private MBRecherche mbRecherche;
	
	@ManagedProperty(value = "#{mbFiche}")
	private MBFiche mbFiche;
	
	private List<Evenement>listEvenement = new ArrayList<Evenement>();
	
	public List<Evenement> getEvenementsByCriteresOrderedByCritere(Theme theme) {
		listEvenement = facade.getServiceRecherche().findEvenementByAllCriteresOrderedByCritere(
mbRecherche.getCategorie(), theme, mbRecherche.getDateDebut(), mbRecherche.getDateFin(), Long.parseLong(mbRecherche.getPrixBas()), Long.parseLong(mbRecherche.getPrixHaut()), mbRecherche.getDepartement(), mbRecherche.getCritereTri());
		return listEvenement;
	}
	
	public String redirectionTheme(Theme theme, Categorie categorie) {
		mbRecherche.setTheme(theme);
		mbRecherche.setCategorie(categorie);
		return "/pages/theme.jsf?faces-redirect=true";
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
		
	public void handleDateSelect(SelectEvent event){
		Date date = (Date)event.getObject();
		minDateFin = date;
	}
	public Date getMinDateFin() {
		return minDateFin;
	}
	public void setMinDateFin(Date minDate) {
		this.minDateFin = minDate;
	}
	public Date getMinDateDebut() {
		return minDateDebut;
	}
	public void setMinDateDebut(Date minDateDebut) {
		this.minDateDebut = minDateDebut;
	}
	public Date minDateEvenement (Evenement evenement){
		return facade.getServiceEvenement().findMinDateEvenement(evenement);
	}
	
	public long minPrixEvenement(Evenement evenement){
		return facade.getServiceEvenement().findMinPrixEvenement(evenement);
	}	
}
