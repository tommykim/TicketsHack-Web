package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoUtilisateur;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

@Repository
@Transactional
public class ImplDaoUtilisateur implements IDaoUtilisateur, Serializable {
	
	EntityManager em;
	
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	private String reqFindByMailAndMdp = "FROM Utilisateur u WHERE u.mail LIKE :paramMail AND u.mdp LIKE :paramMdp";

	@Override
	public Utilisateur insert(Utilisateur utilisateur) {
		em.persist(utilisateur);
		return utilisateur;
		

	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur findById(int idUtilisateur) {
		return em.find(Utilisateur.class, idUtilisateur);
	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> findByMail(String mail) {
		String requete = "SELECT u FROM Utilisateur u where u.mail = :mail";
		TypedQuery<Utilisateur> query = em.createQuery(requete, Utilisateur.class);
		query.setParameter("mail", mail);
		return query.getResultList();
	}


	@Override
	public List<Utilisateur> findByMailAndMdp(String mail, String mdp) {
		TypedQuery<Utilisateur> query = em.createQuery(reqFindByMailAndMdp, Utilisateur.class);
		query.setParameter("paramMail", mail);
		query.setParameter("paramMdp", mdp);
		return query.getResultList();
	}

	@Override
	public void setThemesByUtilisateur(Utilisateur ut, List<Theme> listeT) {
		ut = em.find(Utilisateur.class, ut.getIdUtilisateur());
		ut.getThemes().addAll(new HashSet<>(listeT));
		em.merge(ut);
	}


}
