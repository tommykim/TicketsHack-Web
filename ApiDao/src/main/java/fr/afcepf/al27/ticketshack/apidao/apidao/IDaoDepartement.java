package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;

public interface IDaoDepartement {
	
	public void insert(Departement departement);
	public void update(Departement departement);
	public Departement findById(int idDepartement);
	public List<Departement> findAll();
	public void delete(Departement departement);
	List<Departement> getDepartementsByEvenement(Evenement evenement);
}
