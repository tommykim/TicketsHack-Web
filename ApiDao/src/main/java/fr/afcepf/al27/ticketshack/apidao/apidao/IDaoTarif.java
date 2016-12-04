package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;

public interface IDaoTarif {
	
	public void insert(Tarif tarif);
	public void update(Tarif tarif);
	public Tarif findById(int idTarif);
	public List<Tarif> findAll();
	public void delete(Tarif tarif);
	public Tarif getTarifByLigneCommande(LigneCommande ligneCommande);
	public List<Tarif> findTarifsByOccurence(Occurence occurence);
	public List<Tarif> findTarifsByIdOccurence(int idOccurence); //POUR LE TEST	
	
}
