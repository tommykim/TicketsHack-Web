package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Reduction;

public interface IDaoReduction {
	
	public void insert(Reduction reduction);
	public void update(Reduction reduction);
	public Reduction findById(int idReduction);
	public List<Reduction> findAll();
	public void delete(Reduction reduction);
	
}
