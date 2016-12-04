package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoCategorie;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;

@Repository
@Transactional
public class ImplDaoCategorie implements IDaoCategorie, Serializable {
	
	EntityManager em; 

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub

	}

	@Override
	public Categorie findById(int idCategorie) {
		return em.find(Categorie.class, idCategorie);
	}

	@Override
	public List<Categorie> findAll() {
		String requete = "FROM Categorie";
		TypedQuery<Categorie> query = em.createQuery(requete, Categorie.class);
		return query.getResultList();
	}

	@Override
	public void delete(Categorie categorie) {
		// TODO Auto-generated method stub

	}
	
	
}
