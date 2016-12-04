package fr.afcepf.al27.ticketshack.implservice.implservice;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCategorie;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoDepartement;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoEvenement;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTheme;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceRecherche;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

@Service
public class ImplServiceRecherche implements IServiceRecherche {

	@Autowired
	private IDaoEvenement daoEvenement;
	@Autowired
	private IDaoCategorie daoCategorie;
	@Autowired
	private IDaoTheme daoTheme;
	@Autowired
	private IDaoDepartement daoDepartement;

	@Override
	public List<Evenement> findEvenementByCategorie(int idCategorie) {
		return daoEvenement.findByCategorie(idCategorie);
	}

	@Override
	public List<Evenement> findAllEvenement() {
		return daoEvenement.findAll();
	}

	@Override
	public List<Categorie> findAllCategorie() {
		return daoCategorie.findAll();
	}

	@Override
	public List<Evenement> findEvenementByCategorieOrderedByParution(Categorie categorie) {
		return daoEvenement.findByCategorieOrderedByParution(categorie);
	}

	@Override
	public List<Theme> findThemeByCategorie(Categorie categorie) {
		return daoTheme.findThemeByCategory(categorie);
	}

	@Override
	public List<Evenement> findEvenementsByCategorieAndThemeOrderedByCritere(Categorie categorie, Theme theme, CritereTri critereTri) {
		return daoEvenement.findByCategorieAndThemeOrderedByCritere(categorie, theme, critereTri);
	}
	@Override
	public List<Evenement> findEvenementByAllCriteresOrderedByCritere(
			Categorie categorie, Theme theme, Date dateDebut, Date dateFin, long prixBas, long prixHaut, Departement departement, CritereTri critereTri) {
		return daoEvenement.findByAllCriteresOrderedByCriteres(categorie, theme, dateDebut, dateFin, prixBas, prixHaut, departement, critereTri);
	}

	@Override
	public Categorie findCategorieById(int idCategorie) {
		return daoCategorie.findById(idCategorie);
	}

	
	@Override
	public List<Departement> findAllDepartement() {
		return daoDepartement.findAll();
	}
	
	@Override
	public Departement findDepartementById(int idDepartement) {
		return daoDepartement.findById(idDepartement);
	}

	@Override
	public Theme findThemeById(int idTheme) {
		return daoTheme.findById(idTheme);
	}

	@Override
	public List<Evenement> findEvenementsByTheme(Theme theme) {
		return daoEvenement.findByTheme(theme);
	}
	
}
