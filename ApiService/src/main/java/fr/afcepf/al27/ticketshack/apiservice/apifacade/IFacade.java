package fr.afcepf.al27.ticketshack.apiservice.apifacade;

import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCommande;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCompte;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceEvenement;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceRecherche;



public interface IFacade {

	IServiceEvenement getServiceEvenement(); 
	
	IServiceCompte getServiceCompte();
	
	IServiceRecherche getServiceRecherche();
	
	IServiceCommande getServiceCommande();
	
}
