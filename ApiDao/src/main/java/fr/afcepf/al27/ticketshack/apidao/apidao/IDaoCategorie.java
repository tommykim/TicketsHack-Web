package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;

public interface IDaoCategorie {
	
	public void insert(Categorie categorie);
	public void update(Categorie categorie);
	public Categorie findById(int idCategorie);
	public List<Categorie> findAll();
	public void delete(Categorie categorie);
	
}
