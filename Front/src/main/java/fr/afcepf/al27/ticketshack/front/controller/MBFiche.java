package fr.afcepf.al27.ticketshack.front.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.front.util.TripletDeComparaison;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHack;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHackPortType;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHackRequest;

@ManagedBean(name = "mbFiche")
@SessionScoped
public class MBFiche implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;

	@ManagedProperty(value = "#{MBpanier}")
	private MBPanier mbPanier;

	private String dateDebut;
	private String dateFin;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfSemaine = new SimpleDateFormat("dd/MM/yyyy K EEE");

	private Evenement evenement;
	private List<Occurence> listeOccurence = new ArrayList<Occurence>();
	private List<Departement> listeDepartements = new ArrayList<Departement>();
	private List<Tarif> listeTarifs = new ArrayList<Tarif>();

	private int idOccurence;
	private int idDep;

	private boolean isMultipleOccurence = false;

	private List<LigneCommande> lc = new ArrayList<LigneCommande>();
	private LigneCommande ligne;
	private int placesRestantes ;

//	private List<Evenement> lesRecommandations = new ArrayList<>();

	public void init() {

		if (facade.getServiceEvenement().findOccurencesByEvenement(evenement).size() > 1) {
			setMultipleOccurence(true);
		} else {
			setMultipleOccurence(false);

		}

		setDateDebut(sdf.format(facade.getServiceEvenement().findMinDateEvenement(evenement)));
		dateFin = sdf.format(facade.getServiceEvenement().findMaxDateEvenement(evenement));
		listeOccurence = facade.getServiceEvenement().findOccurencesByEvenement(evenement);
		listeDepartements = facade.getServiceEvenement().findDepartementByEvenement(evenement);
		idOccurence = listeOccurence.get(0).getIdOccurence();
		chargerTarifs();
	}

	public void chargerTarifs() {
		// try {
		// HttpServletRequest request = (HttpServletRequest)
		// FacesContext.getCurrentInstance().getExternalContext().getRequest();
		// String valeur = request.getParameter("toto:occurences_input");
		// idOccurence = Integer.parseInt(valeur);
		// } catch (Exception e) {
		// }

		//**********
		ProcessTicketsHackRequest payload = new ProcessTicketsHackRequest();
		//payload.setCrypto(value);
		String url = "http://localhost:9090/ode/processes/processTicketsHack?wsdl";
		ProcessTicketsHackPortType proxyWs = null;
		try {
			URL wsdUrl = new URL(url);
			proxyWs = (new ProcessTicketsHack(wsdUrl)).getProcessTicketsHackPort();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//*************
		System.out.println("**********************id occurance recuperer ************************* = " + idOccurence);
		listeTarifs = facade.getServiceEvenement().findTarifsByIdOccurence(idOccurence);
		lc.clear();
		for (Tarif t : listeTarifs) {
			lc.add(new LigneCommande(t, 0));
		}

		placesRestantes = facade.getServiceEvenement().getNbPlacesRestantesByIdOccurence(idOccurence);

		System.out.println("**********************placesRestantes ************************* = " + placesRestantes);

		pasDePlace();
		System.out.println("**********************pasDePlace ************************* = " + pasDePlace());

		peuDePlace();
		System.out.println("**********************peuDePlace ************************* = " + peuDePlace());
	}

	public void chargerOccurences(int idDep) {
		listeOccurence = facade.getServiceEvenement().findOccurencesByEvenementAndDepartement(evenement, idDep);
	}

	public void ajouterAuPanier() {
		for (LigneCommande ligne : lc) {
			LigneCommande newLignePanier = new LigneCommande();
			newLignePanier.setTarif(ligne.getTarif());
			newLignePanier.setQuantitie(ligne.getQuantitie());
			if (ligne.getQuantitie() != 0)
				mbPanier.Ajouter(newLignePanier);
		}
		reinitialiserQuantites();
	}

	public List<Evenement> chargerRecommandantions(int idEvenement){
		 List<Evenement> lesRecommandations = new ArrayList<>();

		lesRecommandations.clear();
		List<TripletDeComparaison> listeObjetsLies = new ArrayList<>();

		//ID de l'évenement sur lequel on pointe
//		int idEvenementRef = 1;
//		if (evenement != null)
//		{
//			idEvenementRef = evenement.getIdEvenement();
//		}
		
		//System.out.println(MBFiche.class.getClassLoader().getResource("../Recommandations").getFile();

		try (BufferedReader br = new BufferedReader(new FileReader( MBFiche.class.getClassLoader().getResource("../Recommandations.txt").getFile()))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				TripletDeComparaison trip = new TripletDeComparaison();
				String[] tabVal = sCurrentLine.split(" , ");
				if ((Integer.parseInt(tabVal[0]) == idEvenement) && (Float.parseFloat(tabVal[2]) > 0.39)) {
					trip.setIdCommandeRecherchee(Integer.parseInt(tabVal[0]));
					trip.setIdCommandeCouplee(Integer.parseInt(tabVal[1]));
					trip.setPourcentageDeCouplage(Float.parseFloat(tabVal[2]));
					listeObjetsLies.add(trip);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (TripletDeComparaison t : listeObjetsLies)
		{
			System.out.println(t);
			Evenement e = facade.getServiceEvenement().getEvenementById(t.getIdCommandeCouplee());
			lesRecommandations.add(e);
		}
		
		System.out.println("//////// Taille de la liste des recommandations : " + lesRecommandations.size());
		return lesRecommandations;
	}
	/**
	 * method pour tester si nombre disponibles <0 alros pasPlace est false;
	 * 
	 * @return
	 */
	public boolean pasDePlace() {
		boolean noPlace = true;
		if (placesRestantes > 0) {
			noPlace = false;
		}
		return noPlace;
	}

	/**
	 * method pour tester si nbre place est moins de 50, pour message infos
	 * place Limit.
	 * 
	 * @return
	 */
	public boolean peuDePlace() {
		boolean peuDePlace = false;
		if (placesRestantes > 0 && placesRestantes <= 50) {
			peuDePlace = true;
		}
		return peuDePlace;
	}

	public void convertirDate(Date date) {
		sdfSemaine.format(date);
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void reinitialiserQuantites() {
		for (LigneCommande ligne : lc) {
			ligne.setQuantitie(0);
		}
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
		init();
	}

	public IFacade getFacade() {
		return facade;
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}

	public List<Occurence> getListeOccurence() {
		return listeOccurence;
	}

	public void setListeOccurence(List<Occurence> listeOccurence) {
		this.listeOccurence = listeOccurence;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isMultipleOccurence() {
		return isMultipleOccurence;
	}

	public void setMultipleOccurence(boolean isMultipleOccurence) {
		this.isMultipleOccurence = isMultipleOccurence;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public void setListeDepartements(List<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}

	public int getIdOccurence() {
		return idOccurence;
	}

	public void setIdOccurence(int idOccurence) {
		this.idOccurence = idOccurence;
	}

	public List<Tarif> getListeTarifs() {
		return listeTarifs;
	}

	public void setListeTarifs(List<Tarif> listeTarifs) {
		this.listeTarifs = listeTarifs;
	}

	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public MBPanier getMbPanier() {
		return mbPanier;
	}

	public void setMbPanier(MBPanier mbPanier) {
		this.mbPanier = mbPanier;
	}

	public List<LigneCommande> getLc() {
		return lc;
	}

	public void setLc(List<LigneCommande> lc) {
		this.lc = lc;
	}

	public LigneCommande getLigne() {
		return ligne;
	}

	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}

	public int getPlacesRestantes() {
		return placesRestantes;
	}

	public void setPlacesRestantes(int placesRestantes) {
		this.placesRestantes = placesRestantes;
	}

	
}
