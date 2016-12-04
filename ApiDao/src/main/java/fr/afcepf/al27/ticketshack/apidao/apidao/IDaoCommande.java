package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

public interface IDaoCommande {
	
	public void insert(Commande commande);
	public void update(Commande commande);
	public Commande findById(int idCommande);
	public List<Commande> findAll();
	public void delete(Commande commande);
	public List<Commande> findByUtilisateur(Utilisateur utilisateur);
	
}
