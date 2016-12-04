package fr.afcepf.al27.ticketshack.apiservice.apiservice;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

public interface IServiceCommande {

	public void EnregistrerCommande(Commande commande);
	public List<LigneCommande> FindLigneCommandeByCommande(Commande commande);
	public Tarif FindTarifByLigneCommande(LigneCommande ligneCommande);
	public Occurence FindOccurenceByTarif(Tarif tarif);
	public Evenement FindEvenementByOccurence(Occurence occurence);
	public List<Commande> FindCommandeByUtilisateur(Utilisateur utilisateur);
}
