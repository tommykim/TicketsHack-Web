package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoLigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;

@Transactional
@Repository
public class ImplDaoLigneCommande implements IDaoLigneCommande {

	
	EntityManager em; //

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public void insert(LigneCommande ligneCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(LigneCommande ligneCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public LigneCommande findById(int idLigneCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(LigneCommande ligneCommande) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LigneCommande> FindLigneCommandeByCommande(Commande commande) {
		String requete = "SELECT l FROM LigneCommande l where l.commande=:commande";
		TypedQuery<LigneCommande> query = em.createQuery(requete, LigneCommande.class);
		query.setParameter("commande", commande);
		return query.getResultList();
	}

}
