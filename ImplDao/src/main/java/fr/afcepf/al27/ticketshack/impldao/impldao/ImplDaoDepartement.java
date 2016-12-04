package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoDepartement;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;

@Repository
@Transactional
public class ImplDaoDepartement implements IDaoDepartement, Serializable {
	
	private String reqFindAll = "FROM Departement";
	
	EntityManager em; 

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Departement departement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Departement departement) {
		// TODO Auto-generated method stub

	}

	@Override
	public Departement findById(int idDepartement) {
		return em.find(Departement.class, idDepartement);
	}

	@Override
	public List<Departement> findAll() {
		TypedQuery<Departement> query = em.createQuery(reqFindAll, Departement.class);
		return query.getResultList();
	}

	@Override
	public void delete(Departement departement) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Departement> getDepartementsByEvenement(Evenement evenement) {
		String requete = "SELECT DISTINCT d FROM Departement d INNER JOIN Occurence o ON o.departement.idDep = d.idDep WHERE o.evenement = :evenement";
		TypedQuery<Departement> query = em.createQuery(requete, Departement.class);
		query.setParameter("evenement", evenement);
		return query.getResultList();
	}

}
