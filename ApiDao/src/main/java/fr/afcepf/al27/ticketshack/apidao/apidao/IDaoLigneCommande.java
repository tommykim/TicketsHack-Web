package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;

public interface IDaoLigneCommande {
	
	public void insert(LigneCommande ligneCommande);
	public void update(LigneCommande ligneCommande);
	public LigneCommande findById(int idLigneCommande);
	public List<LigneCommande> findAll();
	public void delete(LigneCommande ligneCommande);
	public List<LigneCommande> FindLigneCommandeByCommande(Commande commande);
	
}
