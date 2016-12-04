package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Civilite;

public interface IDaoCivilite {
	
	public void insert(Civilite civilite);
	public void update(Civilite civilite);
	public Civilite findById(int idCivilite);
	public List<Civilite> findAll();
	public void delete(Civilite civilite);
	
}
