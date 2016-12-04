package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

@ManagedBean(name = "mbRecherche")
@SessionScoped
public class MBRecherche implements Serializable{
	
	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Categorie categorie;
	private Theme theme
	;
	private CritereTri critereTri = CritereTri.NOUVEAUTE;
	
	private Date dateDebut;
	private Date dateFin;
	private String prixBas ="0";
	private String prixHaut= "500";
	private Departement departement;
	private int idDepartement;
	
	private List<Departement> listeDepartements = new ArrayList<Departement>();
	
//	@PostConstruct
	public void init() {
		try {
			 prixBas = "0";
			 prixHaut = "500";
			dateDebut = new Date();
			dateFin = sdf.parse("2020-01-01");
			// On charge la liste des Départements en mémoire, inutile de la recharger à chaque requête.
			listeDepartements = getAllDepartements();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public List<Theme> getThemesByCategorie() {
		return facade.getServiceRecherche().findThemeByCategorie(categorie);
	}
	
	public List<Theme> getThemesByCategorie(Categorie categorie) {
		return facade.getServiceRecherche().findThemeByCategorie(categorie);
	}
	public List<Departement> getAllDepartements() {
		return facade.getServiceRecherche().findAllDepartement();
	}
	
	public List<Evenement> getEvenementsByCategorie(int idCategorie) {
		return facade.getServiceRecherche().findEvenementByCategorie(idCategorie);
	}
	
	
	/**
	 * Méthode très Moche
	 */
	public void affecterCritereTri(int numCritere) {
		switch(numCritere) {
		case 1:
			critereTri = CritereTri.DATE;
			break;
		case 2:
			critereTri = CritereTri.NOUVEAUTE;
			break;
		case 3:
			critereTri = CritereTri.POPULARITE;
			break;
		case 4:
			critereTri = CritereTri.PRIX;
			break;
		}
	}	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public CritereTri getCritereTri() {
		return critereTri;
	}
	public void setCritereTri(CritereTri critereTri) {
		this.critereTri = critereTri;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getPrixBas() {
		return prixBas;
	}
	public void setPrixBas(String prixBas) {
		this.prixBas = prixBas;
	}
	public String getPrixHaut() {
		return prixHaut;
	}
	public void setPrixHaut(String prixHaut) {
		this.prixHaut = prixHaut;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}
	public void setListeDepartements(List<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}
	public int getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
		setDepartement(facade.getServiceRecherche().findDepartementById(idDepartement));
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Date minDateEvenement (Evenement evenement){
		return facade.getServiceEvenement().findMinDateEvenement(evenement);
	}
	
	public long minPrixEvenement(Evenement evenement){
		return facade.getServiceEvenement().findMinPrixEvenement(evenement);
	}
	
}
