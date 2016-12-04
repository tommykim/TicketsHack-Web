package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Civilite;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;;

@ManagedBean(name="mbInscription")
@SessionScoped
public class MBInscription implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion mbConnexion;

	public MBConnexion getMbConnexion() {
		return mbConnexion;
	}

	public void setMbConnexion(MBConnexion mbConnexion) {
		this.mbConnexion = mbConnexion;
	}

	private List<Civilite> civilites = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();

	String[] themesIds;
	
	private Utilisateur utilisateur = new Utilisateur();
	private int idCivilite;
	private String message="";

	@PostConstruct
	public void init(){
		civilites = facade.getServiceCompte().listerCivilites();
		categories = facade.getServiceRecherche().findAllCategorie();
		if(mbConnexion.isConnected()!=false){
			utilisateur = mbConnexion.getUtilisateur();
			idCivilite = utilisateur.getCivilite().getIdCivilite();
		}
	}

	public String enregistrerUtilisateur(){
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Map<String, String[]> params = request.getParameterMap();
		List<Integer> ids = new ArrayList();
		for(String key : params.keySet()){
			if(key.contains("basic")){
				themesIds = params.get(key);
				for (String s: themesIds) {
					ids.add(Integer.parseInt(s));
				}
			}
		}
		

		Utilisateur nouvUtulisateur = new Utilisateur();

		nouvUtulisateur.setCivilite(facade.getServiceCompte().trouverCiviliteParId(idCivilite));
		nouvUtulisateur.setInscription(new Date()); 
		nouvUtulisateur.setMail(utilisateur.getMail());
		nouvUtulisateur.setMdp(utilisateur.getMdp());
		nouvUtulisateur.setMobile(utilisateur.getMobile());
		nouvUtulisateur.setNaissance(utilisateur.getNaissance());
		nouvUtulisateur.setNom(utilisateur.getNom());
		nouvUtulisateur.setPrenom(utilisateur.getPrenom());
		nouvUtulisateur.setStatutUtilisateur(facade.getServiceCompte().trouverStatutParId(1));
	
		List<Theme> liste = new ArrayList<>();
		facade.getServiceCompte().inscrireUtilisateur(nouvUtulisateur);
		
		for (Integer id : ids) {
			liste.add(facade.getServiceCompte().trouverThemeParId(id));
		}
		facade.getServiceCompte().ajouterThemesPareferes(nouvUtulisateur, liste);
		
		utilisateur = nouvUtulisateur;
		
		mbConnexion.setUtilisateur(utilisateur);
		mbConnexion.afficherMessage(utilisateur);
		
		majMessage();
		return retourAccueil();
	}
	
	public String MAJUtilisateur(){
	
		majMessage();
		return retourAccueil();
	}
	
	public void majMessage(){
		if(mbConnexion.isConnected()!=false){
			message = "Vos données de compte ont été enregistrées avec succès !";	
		} else {
			message = "Inscription effectuée avec succès !";
		}
	}
	
	public String retourAccueil(){
		return "accueil.xhtml?faces-redirect=true";
	}


	public IFacade getFacade() {
		return facade;
	}


	public List<Theme> themesParCategorie(Categorie categorie){
		return facade.getServiceCompte().listerThemesParCategorie(categorie);
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}

	public List<Civilite> getCivilites() {
		return civilites;
	}

	public void setCivilites(List<Civilite> civilites) {
		this.civilites = civilites;
	}


	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public int getIdCivilite() {
		return idCivilite;
	}


	public void setIdCivilite(int idCivilite) {
		this.idCivilite = idCivilite;
	}


	public String[] getThemesIds() {
		return themesIds;
	}


	public void setThemesIds(String[] themesIds) {
		this.themesIds = themesIds;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


}
