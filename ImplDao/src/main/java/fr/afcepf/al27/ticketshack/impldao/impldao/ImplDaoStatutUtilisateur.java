package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoStatutUtilisateur;
import fr.afcepf.al27.ticketshack.entity.entity.StatutUtilisateur;

@Repository
@Transactional
public class ImplDaoStatutUtilisateur implements IDaoStatutUtilisateur, Serializable {
	
	EntityManager em;

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Override
	public void insert(StatutUtilisateur statutUtilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StatutUtilisateur statutUtilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public StatutUtilisateur findById(int statutUtilisateur) {
		String requete = "SELECT s FROM StatutUtilisateur s where s.idStatutUtilisateur = :statut";
		TypedQuery<StatutUtilisateur> query = em.createQuery(requete, StatutUtilisateur.class);
		query.setParameter("statut", statutUtilisateur);
		return query.getSingleResult();
	}

	@Override
	public List<StatutUtilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(StatutUtilisateur statutUtilisateur) {
		// TODO Auto-generated method stub

	}

}
