package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoOccurence;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@Repository
@Transactional
public class ImplDaoOccurence implements IDaoOccurence, Serializable {
	
	EntityManager em; 

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Occurence occurence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Occurence occurence) {
		// TODO Auto-generated method stub

	}

	@Override
	public Occurence findById(int idOccurence) {
		return em.find(Occurence.class, idOccurence);
	}

	@Override
	public List<Occurence> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Occurence occurence) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Occurence> getOccurenceByEvenementAndDep(Evenement evenement, int idDepartement) {
		String requete = "SELECT o FROM Occurence o where o.evenement=:evenement and o.departement.idDep=:idDepartement";
		TypedQuery<Occurence> query = em.createQuery(requete, Occurence.class);
		query.setParameter("evenement", evenement);
		query.setParameter("idDepartement", idDepartement);
		return query.getResultList();
	}
	
	@Override
	public List<Occurence> getOccurenceByEvenement(Evenement evenement) {
		String requete = "SELECT o FROM Occurence o where o.evenement=:evenement";
		TypedQuery<Occurence> query = em.createQuery(requete, Occurence.class);
		query.setParameter("evenement", evenement);
		try{
			return query.getResultList();
		} catch (NoResultException e){
			return null;
		}
	}
	@Override
	public Date getMinDateByEvenement(Evenement evenement) {
		String requete = "SELECT MIN(o.date) FROM Occurence o where o.evenement=:evenement";
		Query query = em.createQuery(requete);
		query.setParameter("evenement", evenement);
		return (Date) query.getSingleResult();
	}

	@Override
	public Date getMaxDateByEvenement(Evenement evenement) {
		String requete = "SELECT MAX(o.date) FROM Occurence o where o.evenement=:evenement";
		Query query = em.createQuery(requete);
		query.setParameter("evenement", evenement);
		return (Date) query.getSingleResult();
	}	
	
	@Override
	public List <Occurence> getOccurencesByUtilisateur (Utilisateur utilisateur ) {
		String requete = "SELECT DISTINCT lc.tarif.occurence FROM LigneCommande lc where lc.commande.utilisateur = :utilisateur";
		TypedQuery<Occurence> query = em.createQuery(requete, Occurence.class);
		query.setParameter("utilisateur", utilisateur);
		try{
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}

	@Override
	public Occurence getOccurenceByTarif(Tarif tarif) {
		String requete = "SELECT t.occurence FROM Tarif t WHERE t=:tarif";
		TypedQuery<Occurence> query = em.createQuery(requete, Occurence.class);
		query.setParameter("tarif", tarif);
		return query.getSingleResult();
	}

	@Override
	public List<Occurence> getOccurenceByEvenementAndDep(Evenement evenement,
			Departement departement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getLibelleEvenement(Occurence occurence){
		String requete = "SELECT o.evenement.libelleEvenement from Occurence o where o = :occurence";
		TypedQuery<String> query = em.createQuery(requete, String.class);
		query.setParameter("occurence", occurence);
		return query.getSingleResult();
	}
	
	
	@Override
	public int getNbPlacesRestantesByIdOccurence(int idOccurence) {
		String requete = "SELECT SUM(lc.quantitie) FROM LigneCommande lc WHERE lc.tarif.occurence.idOccurence = :idOccurence "+
				"GROUP BY lc.tarif.occurence.idOccurence"; 
		Query query = em.createQuery(requete);
		query.setParameter("idOccurence", idOccurence);
		int placesAchetes;
		try{
			placesAchetes  = Integer.parseInt(query.getSingleResult().toString());
		} catch (NoResultException e) {
			placesAchetes = 0;
		}
		Occurence o = findById(idOccurence);
		int placesInitiales = o.getNombrePlaces();
		int resultat = placesInitiales - placesAchetes;
		return resultat;	
	}
	
}
