package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoTheme;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;


@Repository
@Transactional
public class ImplDaoTheme implements IDaoTheme, Serializable {
	
	EntityManager em;

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Theme theme) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Theme theme) {
		// TODO Auto-generated method stub

	}

	@Override
	public Theme findById(int idTheme) {
		String requete = "SELECT t FROM Theme t where t.idTheme = :id";
		TypedQuery<Theme> query = em.createQuery(requete, Theme.class);
		query.setParameter("id", idTheme);
		return query.getSingleResult();	
		}

	@Override
	public List<Theme> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Theme theme) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Theme> findThemeByCategory(Categorie categorie){
		String requete = "SELECT t FROM Categorie c join c.themes t where c=:categorie";
		TypedQuery<Theme> query = em.createQuery(requete, Theme.class);
		query.setParameter("categorie", categorie);
		return query.getResultList();	
	}

}
