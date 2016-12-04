package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.StatutUtilisateur;

public interface IDaoStatutUtilisateur {
	
	public void insert(StatutUtilisateur statutUtilisateur);
	public void update(StatutUtilisateur statutUtilisateur);
	public StatutUtilisateur findById(int statutUtilisateur);
	public List<StatutUtilisateur> findAll();
	public void delete(StatutUtilisateur statutUtilisateur);
	
}
