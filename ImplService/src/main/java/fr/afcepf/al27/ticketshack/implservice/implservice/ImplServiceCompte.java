package fr.afcepf.al27.ticketshack.implservice.implservice;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCivilite;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoOccurence;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoStatutUtilisateur;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTheme;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoUtilisateur;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCompte;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Civilite;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.StatutUtilisateur;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@Service
public class ImplServiceCompte implements IServiceCompte, Serializable{
	
	
	@Autowired
	private IDaoTheme daoTheme;
	
	@Autowired
	private IDaoCivilite daoCivilite;
	
	@Autowired
	private IDaoUtilisateur daoUtilisateur;
	
	@Autowired
	private IDaoStatutUtilisateur daoStatutUtilisateur;
	
	@Autowired
	private IDaoOccurence daoOccurence;
	

	@Override
	public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
		if(daoUtilisateur.findByMail(utilisateur.getMail()).size()==0){
			return daoUtilisateur.insert(utilisateur);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Civilite> listerCivilites() {
		return daoCivilite.findAll();
	}

	@Override
	public List<Theme> listerThemesParCategorie(Categorie categorie) {
		return daoTheme.findThemeByCategory(categorie);
	}

	@Override
	public Utilisateur authentifierUtilisateur(String mail, String mdp) {
		Utilisateur utilisateur = null;
		List<Utilisateur> listeUtilisateurs = daoUtilisateur.findByMailAndMdp(mail, mdp);
		if(listeUtilisateurs.size() == 1) { 
			utilisateur = listeUtilisateurs.get(0);
		}		
		return utilisateur;
	}

	@Override
	public StatutUtilisateur trouverStatutParId(int id) {
		return daoStatutUtilisateur.findById(id);
	}

	@Override
	public Civilite trouverCiviliteParId(int id) {
		return daoCivilite.findById(id);
	}
	
	@Override
	public Theme trouverThemeParId(int id) {
		return daoTheme.findById(id);
	}
	
	
	@Override
	public void ajouterThemesPareferes(Utilisateur u, List<Theme> listeT) {
		daoUtilisateur.setThemesByUtilisateur(u, listeT);
		
	}

	@Override
	public Utilisateur FindUtilisateurById(int idUtilisateur) {
		return daoUtilisateur.findById(idUtilisateur);
	}

	@Override
	public List<Occurence> findOccurencesbyUtilisateur(Utilisateur utilisateur) {
		return daoOccurence.getOccurencesByUtilisateur(utilisateur);
	} 
	
	@Override
	public String getLibelleEvenementByOccurence (Occurence occurence) {
		return daoOccurence.getLibelleEvenement(occurence);
	} 
	
	

}
