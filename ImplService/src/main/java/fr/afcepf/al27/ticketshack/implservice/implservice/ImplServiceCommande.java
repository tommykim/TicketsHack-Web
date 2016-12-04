package fr.afcepf.al27.ticketshack.implservice.implservice;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCommande;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoEvenement;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoLigneCommande;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoOccurence;
import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTarif;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@Service
public class ImplServiceCommande implements IServiceCommande, Serializable {

	@Autowired
	private IDaoCommande daoCommande;
	
	@Autowired
	private IDaoTarif daoTarif;
	
	@Autowired
	private IDaoLigneCommande daoLigneCommande;
	
	@Autowired
	private IDaoOccurence daoOccurence;
	
	@Autowired
	private IDaoEvenement daoEvenement;

	@Override
	public void EnregistrerCommande(Commande commande) {
		daoCommande.insert(commande);
		
	}

	@Override
	public Tarif FindTarifByLigneCommande(LigneCommande ligneCommande) {
		return daoTarif.getTarifByLigneCommande(ligneCommande);
	}

	@Override
	public List<LigneCommande> FindLigneCommandeByCommande(Commande commande) {
		return daoLigneCommande.FindLigneCommandeByCommande(commande);
	}

	@Override
	public Occurence FindOccurenceByTarif(Tarif tarif) {
		return daoOccurence.getOccurenceByTarif(tarif);
	}

	@Override
	public Evenement FindEvenementByOccurence(Occurence occurence) {
		return daoEvenement.findByOccurence(occurence);
	}

	@Override
	public List<Commande> FindCommandeByUtilisateur(Utilisateur utilisateur) {
		return daoCommande.findByUtilisateur(utilisateur);
	}
	
}
