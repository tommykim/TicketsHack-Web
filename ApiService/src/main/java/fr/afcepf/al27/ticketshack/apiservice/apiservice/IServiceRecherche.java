package fr.afcepf.al27.ticketshack.apiservice.apiservice;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

public interface IServiceRecherche {

	List<Evenement> findEvenementByCategorie(int idCategorie);
	List<Evenement> findEvenementByCategorieOrderedByParution(Categorie categorie);
	List<Evenement> findAllEvenement();
	List<Categorie> findAllCategorie();
	List<Theme> findThemeByCategorie(Categorie categorie);
	@Deprecated
	List<Evenement> findEvenementsByCategorieAndThemeOrderedByCritere(Categorie categorie, Theme theme, CritereTri critereTri);
	List<Evenement> findEvenementByAllCriteresOrderedByCritere(Categorie categorie, Theme theme, Date dateDebut, 
			  Date dateFin, long prixBas, long prixHaut, Departement departement, CritereTri critereTri);
	Categorie findCategorieById(int idCategorie);
	List<Departement> findAllDepartement();
	Departement findDepartementById(int idDepartement);
	Theme findThemeById(int idTheme);
	List<Evenement> findEvenementsByTheme(Theme theme);
	
}
