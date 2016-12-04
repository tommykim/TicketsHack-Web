package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

public interface IDaoEvenement {

	public Evenement findById(int idEvenement);
	public List<Evenement> findAll();
	public List<Evenement> findByCategorie(int idCategorie);
	public void insert(Evenement evenement);
	public void update(Evenement evenement);
	public void delete(Evenement evenement);
	public Evenement findByOccurence(Occurence occurence);
	public List<Evenement> findByCategorieOrderedByParution(Categorie categorie);
	@Deprecated
	public List<Evenement> findByCategorieAndThemeOrderedByCritere(
			Categorie categorie, Theme theme, CritereTri critereTri);
	public List<Evenement> findByAllCriteresOrderedByCriteres(Categorie categorie, Theme theme, Date dateDebut, 
			  Date dateFin, long prixBas, long prixHaut, Departement departement, CritereTri critereTri);
	public List<Evenement> findByTheme(Theme theme);
	long findMinPrixByEvenement(Evenement evenement);
}
