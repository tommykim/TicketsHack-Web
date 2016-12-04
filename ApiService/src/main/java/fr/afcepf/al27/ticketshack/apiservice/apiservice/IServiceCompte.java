package fr.afcepf.al27.ticketshack.apiservice.apiservice;

import java.util.List;

import com.mysql.jdbc.Util;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Civilite;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.StatutUtilisateur;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

public interface IServiceCompte {
	
	Utilisateur inscrireUtilisateur (Utilisateur utilisateur);
	List<Civilite> listerCivilites();
	List<Theme> listerThemesParCategorie(Categorie categorie);
	Utilisateur authentifierUtilisateur (String mail, String mdp);
	StatutUtilisateur trouverStatutParId(int id);
	void ajouterThemesPareferes(Utilisateur u, List<Theme> listeT);
	Civilite trouverCiviliteParId(int id);
	Theme trouverThemeParId(int id);
	Utilisateur FindUtilisateurById(int idUtilisateur);
	List<Occurence> findOccurencesbyUtilisateur(Utilisateur utilisateur);
	String getLibelleEvenementByOccurence(Occurence occurence);

		
}
