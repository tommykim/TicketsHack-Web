package fr.afcepf.al27.ticketshack.impldao.impldao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.print.attribute.standard.Finishings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al27.ticketshack.apidao.apidao.IDaoEvenement;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.CritereTri;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

@Repository
@Transactional
public class ImplDaoEvenement implements IDaoEvenement{
	
	private String reqFindAll = "FROM Evenement";
	private String reqFindByCategorie = "FROM Evenement evenement WHERE evenement.categorie.idCategorie = :paramIdCategorie";
	private String reqFindByCategorieOrderedByParution = "FROM Evenement evenement WHERE evenement.categorie = :paramCategorie ORDER BY evenement.parution DESC";
	private String reqFindByAllCriteresOrderedByCritere = 
			"SELECT e "
			+ "FROM Evenement e "
				+ "JOIN e.themes th "
					+ "JOIN e.occurences o "
						+ "JOIN o.tarifs ta "
			+ "WHERE e.categorie = :paramCategorie "
			+ "AND th = :paramTheme "
			+ "AND o.date BETWEEN :paramDateDebut AND :paramDateFin "
			+ "AND ta.prix BETWEEN :paramPrixBas AND :paramPrixHaut ";

	EntityManager em;
	
	@PersistenceContext(unitName="entityManagerFactory")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Evenement findById(int idEvenement) {
		return em.find(Evenement.class, idEvenement);
	}

	@Override
	public List<Evenement> findAll() {
		TypedQuery<Evenement> query = em.createQuery(reqFindAll, Evenement.class);
		return query.getResultList();
	}

	@Override
	public List<Evenement> findByCategorie(int idCategorie) {
		TypedQuery<Evenement> query = em.createQuery(reqFindByCategorie, Evenement.class);
		query.setParameter("paramIdCategorie", idCategorie);
		return query.getResultList();
	}

	@Override
	public void insert(Evenement evenement) {
		em.persist(evenement);
	}

	@Override
	public void update(Evenement evenement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Evenement evenement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evenement> findByCategorieOrderedByParution(Categorie categorie) {
		TypedQuery<Evenement> query = em.createQuery(reqFindByCategorieOrderedByParution, Evenement.class);
		query.setParameter("paramCategorie", categorie);
		return query.getResultList();
	}

	@Deprecated
	@Override
	public List<Evenement> findByCategorieAndThemeOrderedByCritere(Categorie categorie, Theme theme, CritereTri critereTri) {
		String join = "";
		String groupBy = "";
		String orderBy = "";
		
		switch(critereTri) {
		case NOUVEAUTE:
			orderBy = "e.parution";
			break;
		case POPULARITE:
			break;
		case DATE:
			join = "JOIN e.occurences o ";
			groupBy = "GROUP BY e ";
			orderBy = "min(o.date)";
			break;
		case PRIX:
			join = "JOIN e.occurences o JOIN o.tarifs ta ";
			groupBy = "GROUP BY e ";
			break;
		}
		String reqFindByCategorieAndThemeOrderedByCritere = 
				"Select e FROM Evenement e " 
					      + "JOIN e.categorie c "
					         + "JOIN e.themes th "
					         	+ join
					      + "WHERE c = :paramCategorie "
							 + "AND th = :paramTheme "
					   + groupBy
					   + "ORDER BY :paramTri";
		TypedQuery<Evenement> query = em.createQuery(reqFindByCategorieAndThemeOrderedByCritere, Evenement.class);
		query.setParameter("paramCategorie", categorie);
		query.setParameter("paramTheme", theme);
		query.setParameter("paramTri", orderBy);
		return query.getResultList();
	}
	
	/**
	 * TODO:
	 * - Pour l'instant la recherche par Département n'est pas encore codée
	 * - Il faut précisier que la dateDebut ne peut pas être plus tôt que la date du Jour (ne pas afficher les évènement dont il ne reste plus d'occurences)
	 */
	@Override
	public List<Evenement> findByAllCriteresOrderedByCriteres(
			Categorie categorie, Theme theme, Date dateDebut, Date dateFin, long prixBas, long prixHaut, Departement departement, CritereTri critereTri) {
		
		// Ceci est la sous-requête pour Récupérer le Ratio de Popularité entre la Première et la Dernière Occurence passée pour un Evènement donné.
		// Etroitement liée à la Requête partielle définie en attribut de cette Classe
		String sousReqRatio = "(SELECT SUM(lc1.quantitie)/o1.nombrePlaces*100 "
				+ "FROM LigneCommande lc1 "
				+ "JOIN lc1.tarif ta1 "
				+ "JOIN ta1.occurence o1 "
				+ "JOIN o1.evenement e1 "
				+ "WHERE o1.date = (Select max(o1.date) FROM o1 WHERE o1.date < SYSDATE()) "
				+ "AND e1 = e) / "
				+ "(SELECT SUM(lc2.quantitie)/o2.nombrePlaces*100 "
				+ "FROM LigneCommande lc2 "
				+ "JOIN lc2.tarif ta2 "
				+ "JOIN ta2.occurence o2 "
				+ "JOIN o2.evenement e2 "
				+ "WHERE o2.date = (Select min(o2.date) FROM o2 WHERE o2.date < SYSDATE()) "
				+ "AND e2 = e)";
		
		String reqFindByAllCriteresOrderedByCritereComplete = reqFindByAllCriteresOrderedByCritere;
		
		// Cela est la partie de la Requête pour limiter la Recherche à un Département
			String partieRequeteDepartement = "AND o.departement = :paramDepartement "; 
			if(departement != null)
				reqFindByAllCriteresOrderedByCritereComplete += partieRequeteDepartement;
		// Ajout de la partie GROUP BY
		String partieRequeteGroupBy = "GROUP BY e ";
		reqFindByAllCriteresOrderedByCritereComplete += partieRequeteGroupBy;
		// Détermination de la partie 'Order By' de la Requête
		String orderBy = "ORDER BY ";
		switch(critereTri) {
		case NOUVEAUTE:
			orderBy += "e.parution";
			break;
		case POPULARITE:
			orderBy += sousReqRatio;
			break;
		case DATE:
			orderBy += "min(o.date)";
			break;
		case PRIX:
			orderBy += "min(ta.prix)";
			break;
		}
		orderBy += " DESC";
		reqFindByAllCriteresOrderedByCritereComplete += orderBy;
		// Paramétrage de la Requête
		TypedQuery<Evenement> query = em.createQuery(reqFindByAllCriteresOrderedByCritereComplete, Evenement.class);
		query.setParameter("paramCategorie", categorie);
		query.setParameter("paramTheme", theme);
		query.setParameter("paramDateDebut", dateDebut);
		query.setParameter("paramDateFin", dateFin);
		query.setParameter("paramPrixBas", prixBas);
		query.setParameter("paramPrixHaut", prixHaut);
		if(departement != null)
			query.setParameter("paramDepartement", departement);
		return query.getResultList();
	}

	@Override
	public Evenement findByOccurence(Occurence occurence) {
		String requete = "SELECT o.evenement FROM Occurence o WHERE o=:occurence";
		TypedQuery<Evenement> query = em.createQuery(requete, Evenement.class);
		query.setParameter("occurence", occurence);
		return query.getSingleResult();
	}

	@Override
	public List<Evenement> findByTheme(Theme theme) {
		String requete = "SELECT e FROM Theme th JOIN th.evenements e WHERE th = :paramTheme";
		TypedQuery<Evenement> query = em.createQuery(requete, Evenement.class);
		query.setParameter("paramTheme", theme);
		return query.getResultList();
	}
	
	@Override
	public long findMinPrixByEvenement(Evenement evenement) {
		String requete = "SELECT MIN(t.prix) FROM Tarif t WHERE t.occurence.evenement = :paramEvenement";
		Query query = em.createQuery(requete);
		query.setParameter("paramEvenement", evenement);
		long minPrix=0l; 
		try{
			System.out.println(query.getSingleResult());
			if(query.getSingleResult()!=null){
			minPrix = (long)query.getSingleResult();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return minPrix;
	}
	
}
