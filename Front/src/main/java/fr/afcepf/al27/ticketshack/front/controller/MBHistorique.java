package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@ManagedBean(name = "MBhistorique")
@RequestScoped
public class MBHistorique implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	
	public IFacade getFacade() {
		return facade;
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}

	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion mbConnexion;
	
	public MBConnexion getMbConnexion() {
		return mbConnexion;
	}

	public void setMbConnexion(MBConnexion mbConnexion) {
		this.mbConnexion = mbConnexion;
	}
	
	private List<Commande> listCommande;
	private List<LigneCommande> listeLigneCommande;
	private Tarif tarif;
	private Occurence occurence;
	private Evenement evenement;
	
	@PostConstruct
	public void init(){
		listCommande = getListCommande(mbConnexion.getUtilisateur());
	}
	
	public List<Commande> getListCommande() {
		return listCommande;
	}
	
	public List<Commande> getListCommande(Utilisateur utilisateur) {
		return facade.getServiceCommande().FindCommandeByUtilisateur(utilisateur);
	}

	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}
	
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}
	
	public List<LigneCommande> getListeLigneCommande(Commande commande) {
		return facade.getServiceCommande().FindLigneCommandeByCommande(commande);
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}

	public Tarif getTarif() {
		return tarif;
	}
	
	public Tarif getTarif(LigneCommande ligneCommande) {
		return facade.getServiceCommande().FindTarifByLigneCommande(ligneCommande);
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	public Occurence getOccurence() {
		return occurence;
	}
	
	public Occurence getOccurence(Tarif tarif) {
		return facade.getServiceCommande().FindOccurenceByTarif(tarif);
	}

	public void setOccurence(Occurence occurence) {
		this.occurence = occurence;
	}

	public Evenement getEvenement() {
		return evenement;
	}
	
	public Evenement getEvenement(Occurence occurence) {
		return facade.getServiceCommande().FindEvenementByOccurence(occurence);
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	
	public int Total(int prix, int quantite){
		return prix*quantite;
	}
	
	public int Totaux(Commande commande){
		int total = 0;
			for(LigneCommande ligneCommande : getListeLigneCommande(commande)){
				total = (int) (total + ligneCommande.getQuantitie()*facade.getServiceCommande().FindTarifByLigneCommande(ligneCommande).getPrix());
			}
		return total;
	}
	
	public String retour(){
		return "Historique.xhtml?faces-redirect=true";
	}

}
