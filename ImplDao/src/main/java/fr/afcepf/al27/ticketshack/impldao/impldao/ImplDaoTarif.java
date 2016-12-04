package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTarif;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;

@Transactional
@Repository
public class ImplDaoTarif implements IDaoTarif {

	EntityManager em;
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
	this.em = em;
	}
	
	@Override
	public void insert(Tarif tarif) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Tarif tarif) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tarif findById(int idTarif) {
		return em.find(Tarif.class, idTarif);
	}

	@Override
	public List<Tarif> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tarif tarif) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tarif getTarifByLigneCommande(LigneCommande ligneCommande) {
		String requete = "SELECT l.tarif FROM LigneCommande l WHERE l=:ligneCommande";
		TypedQuery<Tarif> query = em.createQuery(requete, Tarif.class);
		query.setParameter("ligneCommande", ligneCommande);
		return query.getSingleResult();
	}

	@Override
	public List<Tarif> findTarifsByOccurence(Occurence occurence) {
		String requete = "SELECT t from Tarif t WHERE t.occurence = :occurence";
		TypedQuery<Tarif> query = em.createQuery(requete, Tarif.class);
		query.setParameter("occurence", occurence);
		try{
			return query.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Tarif> findTarifsByIdOccurence(int idOccurence) {
		String requete = "SELECT t from Tarif t WHERE t.occurence.idOccurence = :idOccurence";
		TypedQuery<Tarif> query = em.createQuery(requete, Tarif.class);
		query.setParameter("idOccurence", idOccurence);
		try{
			return query.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
	}
}
