package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCivilite;
import fr.afcepf.al27.ticketshack.entity.entity.Civilite;
import fr.afcepf.al27.ticketshack.entity.entity.StatutUtilisateur;


@Repository
@Transactional
public class ImplDaoCivilite implements IDaoCivilite, Serializable {


	EntityManager em;

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Civilite civilite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Civilite civilite) {
		// TODO Auto-generated method stub

	}

	@Override
	public Civilite findById(int id) {
		String requete = "SELECT c FROM Civilite c where c.idCivilite = :id";
		TypedQuery<Civilite> query = em.createQuery(requete, Civilite.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Civilite> findAll() {
		String requete = "FROM Civilite";
		TypedQuery<Civilite> query = em.createQuery(requete,Civilite.class);
		return query.getResultList();
	}

	@Override
	public void delete(Civilite civilite) {
		// TODO Auto-generated method stub

	}

}
