package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@ManagedBean(name = "mbConnexion")
@SessionScoped
public class MBConnexion implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	private Utilisateur utilisateur = new Utilisateur();
	private String messageBonjour;
	public String authentification() {
		
		Utilisateur utilisateurEnConnexion = facade.getServiceCompte().authentifierUtilisateur(utilisateur.getMail(), utilisateur.getMdp());
		if(utilisateurEnConnexion != null) {
			afficherMessage(utilisateurEnConnexion);
			this.utilisateur = utilisateurEnConnexion;
		} else {
			messageBonjour = "Erreur de Connexion !";
		}
		return null;
	}
	
	public String connectGoToPanier(){
		Utilisateur utilisateurEnConnexion = facade.getServiceCompte().authentifierUtilisateur(utilisateur.getMail(), utilisateur.getMdp());
		if(utilisateurEnConnexion != null) {
			afficherMessage(utilisateurEnConnexion);
			this.utilisateur = utilisateurEnConnexion;
			return "panier.xhtml?faces-redirect=true";
		} else {
			messageBonjour = "Erreur de Connexion !";
		}
		return null;
	}
	
	public void afficherMessage(Utilisateur ut){
		messageBonjour = "Bonjour " + ut.getPrenom();
	}
	
	
	public String deconnexion() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        return "index.xhtml?faces-redirect=true";
	}
	public boolean isConnected() {
		if(utilisateur==null)
			return false;
		return this.utilisateur.getIdUtilisateur()!=null;
	}
	public boolean isFournisseur() {
		if(utilisateur==null)
			return false;
		return this.utilisateur.getStatutUtilisateur().getIdStatutUtilisateur() == 3;
	}
	public boolean isAdministrator(){
		if(utilisateur==null)
			return false;
		return this.utilisateur.getStatutUtilisateur().getIdStatutUtilisateur() == 2;
	}
	
	public boolean isClient(){
		if(utilisateur==null)
			return false;
		return this.utilisateur.getStatutUtilisateur().getIdStatutUtilisateur() == 1;
	}
	public String GestionEvenement() {
		return "gestionEvenement.xhtml?faces-redirect=true";
	}
	public String MonCompte() {
		return "inscription.xhtml?faces-redirect=true";
	}
	public String Historique() {
		return "Historique.xhtml?faces-redirect=true";
	}
	public String Agenda() {
		return "agenda.xhtml?faces-redirect=true";
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getMessageBonjour() {
		return messageBonjour;
	}
	public void setMessageBonjour(String messageBonjour) {
		this.messageBonjour = messageBonjour;
	}
	
	
}
