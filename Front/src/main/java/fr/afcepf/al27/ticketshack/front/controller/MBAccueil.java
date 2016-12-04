package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;

@ManagedBean(name = "mbAccueil")
@SessionScoped
public class MBAccueil implements Serializable{

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	private Categorie categorie = new Categorie(); 
	
	@ManagedProperty(value = "#{mbRecherche}")
	private MBRecherche mbRecherche;

	@ManagedProperty(value = "#{mbFiche}")
	private MBFiche mbFiche;
	
	private List<Categorie> listCategories = new ArrayList<Categorie>();
	
	public List<Evenement> getEvenementsByCategorie(int idCategorie) {
		return facade.getServiceRecherche().findEvenementByCategorie(idCategorie);
	}
	
	public List<Categorie> getAllCategorie() {
		listCategories = facade.getServiceRecherche().findAllCategorie();
		return listCategories;
	}
	
	public List<Evenement> getEvenementByCategorieOrderedByParution(Categorie categorie) {
		return facade.getServiceRecherche().findEvenementByCategorieOrderedByParution(categorie);
	}
	
	public String redirectionCategorie(Categorie categorie) {
		mbRecherche.setCategorie(categorie);
		return "categorie.xhtml?faces-redirect=true";
	}
	public String redirectionFicheDescriptive(Evenement evenement) {
		mbFiche.setEvenement(evenement);
		return "fiche.xhtml?faces-redirect=true";
	}
	public String redirectionPanier() {
		return "panier.xhtml?faces-redirect=true";
	}
	public String redirectionCategorieById(int idCategorie) {
		return redirectionCategorie(
				facade.getServiceRecherche().findCategorieById(idCategorie));
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
	public List<Categorie> getListCategories() {
		return listCategories;
	}
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
