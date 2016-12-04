package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@Repository
@Transactional
public class ImplDaoCommande implements IDaoCommande {
	
	EntityManager em; //

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Commande commande) {
		em.persist(commande);

	}

	@Override
	public void update(Commande commande) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commande findById(int idCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Commande commande) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commande> findByUtilisateur(Utilisateur utilisateur) {
		String requete = "SELECT c FROM Commande c where c.utilisateur=:utilisateur";
		TypedQuery<Commande> query = em.createQuery(requete, Commande.class);
		query.setParameter("utilisateur", utilisateur);
		return query.getResultList();
	}

}
