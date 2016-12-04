package fr.afcepf.al27.ticketshack.front.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.BindingProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Commande;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.LigneCommande;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;
import fr.afcepf.al27.ticketshack.front.util.OccurenceDto;
import fr.afcepf.al27.ticketshack.front.util.ParseurJson;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHack;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHackPortType;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHackRequest;
import fr.afcepf.al28.ticketshack.bpel.ProcessTicketsHackResponse;

@ManagedBean(name = "MBpanier")
@SessionScoped
public class MBPanier implements Serializable {

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;

	public IFacade getFacade() {
		return facade;
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}

	@ManagedProperty(value = "#{MBHistorique}")
	private MBHistorique mbHistorique;

	public MBHistorique getMbHistorique() {
		return mbHistorique;
	}

	public void setMbHistorique(MBHistorique mbHistorique) {
		this.mbHistorique = mbHistorique;
	}

	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion mbConnexion;

	public MBConnexion getMbConnexion() {
		return mbConnexion;
	}

	public void setMbConnexion(MBConnexion mbConnexion) {
		this.mbConnexion = mbConnexion;
	}

	private Commande commande;
	private List<Commande> listCommande;
	private List<LigneCommande> listeLigneCommande;
	private Tarif tarif;
	private Occurence occurence;
	private Evenement evenement;
	private Utilisateur utilisateur;
	private List<OccurenceDto> listOccurences;
	private int nbrPlaceReal;
	private Map<Integer, Integer> map;

	// **********************************************************************
	private String moisExpiration;
	private String anneeExpiration;
	private String numeroCarte;
	private String crypto;
	private String dateExpiration;
	private boolean paiementEchec = false;

	@PostConstruct
	public void init() {
		commande = new Commande();
		listeLigneCommande = new ArrayList<LigneCommande>(0);
		map = new HashMap<Integer, Integer>();
	}

	public void reset(){
		map = new HashMap<Integer, Integer>();
	}
	public void initCheckOutPaiment() {
		paiementEchec = false;
	}

	public void Ajouter(LigneCommande ligne) {
		if (ligne.getQuantitie() != 0)
			listeLigneCommande.add(ligne);
	}

	public String Retirer(LigneCommande ligneCommande) {
		listeLigneCommande.remove(ligneCommande);
		return "panier.xhtml?faces-redirect=true";
	}

	public void Modifier(LigneCommande ligneCommande, int quantite) {
		ligneCommande.setQuantitie(quantite);
	}

	public String validerPanier() {
		String page = null;

		if (mbConnexion.isConnected() != false) {
			for (LigneCommande l : listeLigneCommande)
				l.setCommande(commande);
			commande.setLigneCommandes(listeLigneCommande);
			commande.setReference(String.valueOf(listeLigneCommande.hashCode()));
			// listeLigneCommande.clear();
			page = "checkoutpayment.xhtml?faces-redirect=true";
		} else {
			page = "register.xhtml?faces-redirect=true";
		}
		return page;
	}

	public String validerPaiement() {
		dateExpiration = moisExpiration + anneeExpiration;
		System.out.println("******************************************dataexpiration " + dateExpiration);
		System.out.println(
				"******************************************crypto " + crypto + "*** numero carte" + numeroCarte);
		String page = null;
		String commandeAEnvoyer = null;
		Integer intMontant = Totaux();
		String reponseProxy = "";
		BigInteger montant = BigInteger.valueOf(intMontant.intValue());
		// *******************************************************************************

		listOccurences = new ArrayList<OccurenceDto>();

		for (LigneCommande l : listeLigneCommande) {
			OccurenceDto o = new OccurenceDto();
			o.setId_occurence(l.getTarif().getOccurence().getIdOccurence());
			o.setNbPlaces(l.getQuantitie());
			listOccurences.add(o);
		}

		commandeAEnvoyer = objectToJson(listOccurences);

		ProcessTicketsHackRequest payload = new ProcessTicketsHackRequest();
		payload.setCrypto(crypto);
		payload.setDateExpiration(dateExpiration);
		payload.setMontant(montant);
		payload.setNumeroCarte(numeroCarte);
		payload.setListeResa(commandeAEnvoyer);

		String url = "http://localhost:9090/ode/processes/processTicketsHack?wsdl";
		ProcessTicketsHackPortType proxyWs = null;

		try {
			URL wsdUrl = new URL(url);
			proxyWs = (new ProcessTicketsHack(wsdUrl)).getProcessTicketsHackPort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BindingProvider bp = (BindingProvider) proxyWs;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:9090/ode/processes/processTicketsHack");
		ProcessTicketsHackResponse response = proxyWs.process(payload);
		reponseProxy = response.getResult();
		System.out.println("*******reponseproxy*******************" + reponseProxy);

		switch (reponseProxy) {

		case "payer":
			// paiemnt reussit dont reservation reussit
			commande.setDateCreation(new Date());
			Utilisateur u = new Utilisateur();
			u.setIdUtilisateur(mbConnexion.getUtilisateur().getIdUtilisateur());
			u.setCivilite(mbConnexion.getUtilisateur().getCivilite());
			u.setInscription(mbConnexion.getUtilisateur().getInscription());
			u.setMail(mbConnexion.getUtilisateur().getMail());
			u.setMdp(mbConnexion.getUtilisateur().getMdp());
			u.setMobile(mbConnexion.getUtilisateur().getMobile());
			u.setNaissance(mbConnexion.getUtilisateur().getNaissance());
			u.setNom(mbConnexion.getUtilisateur().getNom());
			u.setPrenom(mbConnexion.getUtilisateur().getPrenom());
			u.setReduction(mbConnexion.getUtilisateur().getReduction());
			u.setStatutUtilisateur(mbConnexion.getUtilisateur().getStatutUtilisateur());
			Commande cmd = new Commande();
			for (LigneCommande l : listeLigneCommande) {
				l.setCommande(cmd);
			}
			cmd.setLigneCommandes(listeLigneCommande);
			cmd.setDateCreation(new Date());
			cmd.setLigneCommandes(listeLigneCommande);
			cmd.setReference(String.valueOf(new Date().hashCode()));
			cmd.setUtilisateur(u);
			commande.setUtilisateur(u);
			// commande.setUtilisateur(mbConnexion.getUtilisateur());
			facade.getServiceCommande().EnregistrerCommande(cmd);
			listeLigneCommande.clear();
			page = "customerorders.xhtml?faces-redirect=true";
			break;

		case "nonpayer":
			// paiement echec
			paiementEchec = true;
			page = "checkoutpayment.xhtml?faces-redirect=true";
			break;

		case "nonvalider":
			// carte Invalide
			paiementEchec = true;
			page = "checkoutpayment.xhtml?faces-redirect=true";
			break;

		default:

			String listNonDispoJsonInput = reponseProxy;
			listOccurences = jsonToObjet(listNonDispoJsonInput);
			System.out.println("*********listOccurences****" + listOccurences);
			 map = new HashMap<Integer, Integer>();
			
			for (Object b2 : listOccurences) {
				System.out.println(" b2 : " +  b2);
				for(OccurenceDto dto : listOccurences) {
					map.put(dto.getId_occurence(), dto.getNbPlaces());
				}
				/*LigneCommande ligneCommande = new LigneCommande();
				ligneCommande.getTarif().getOccurence().setIdOccurence(b2.getId_occurence());
				ligneCommande.getTarif().getOccurence().setNombrePlaces(b2.getNbPlaces());
				listeLigneCommande.add(ligneCommande);
				System.out.println("********lignecommande**********" + ligneCommande);

				System.out.println("size list ligne commande******" + listeLigneCommande.size());

				//isNotDispo = true;	*/
				}
		page = "panier.xhtml?faces-redirect=true";
		
		}
		
		return page;
	}
	public List<OccurenceDto> jsonToObjet(String jsonInput) {
		List<OccurenceDto> listeOutput = new ArrayList<OccurenceDto>();
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		json = jsonInput.replaceAll("\"", "\\\"");
		try {
		listeOutput = mapper.readValue(json, new TypeReference<List<OccurenceDto>>() {});
		} catch(Exception e) {
			e.printStackTrace();
		}
		return listeOutput;
	}
	public String objectToJson(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		String stringOutput = "";

		try {
			stringOutput = mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return stringOutput;
	}
	
	public boolean afficherDispo(int idOccurrence, int qteDemandee) {
		if(map != null && !map.isEmpty() && (int)map.get(idOccurrence) < qteDemandee) {
			nbrPlaceReal = (int)map.get(idOccurrence);
			return true;
		} else {
			return false;
		}
	}
	public int Total(int prix, int quantite) {
		return prix * quantite;
	}

	public int Totaux() {
		int total = 0;
		for (LigneCommande ligneCommande : getListeLigneCommande()) {
			total = (int) (total + ligneCommande.getQuantitie() * ligneCommande.getTarif().getPrix());
		}
		return total;
	}

	public String redirection() {
		return "checkoutpayment.xhtml?faces-redirect=true";
	}

	public List<Commande> getListCommande() {
		return listCommande;
	}

	public List<Commande> getListCommande(Utilisateur utilisateur) {
		return facade.getServiceCommande().FindCommandeByUtilisateur(utilisateur);
	}

	public void setListCommande(List<Commande> listCommande) {
		this.listCommande = listCommande;
	}

	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	public List<LigneCommande> getListeLigneCommande(Commande commande) {
		return facade.getServiceCommande().FindLigneCommandeByCommande(commande);
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}

	public Tarif getTarif() {
		return tarif;
	}

	public Tarif getTarif(LigneCommande ligneCommande) {
		return ligneCommande.getTarif();
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	public Occurence getOccurence() {
		return occurence;
	}

	public Occurence getOccurence(Tarif tarif) {
		return facade.getServiceCommande().FindOccurenceByTarif(tarif);
	}

	public void setOccurence(Occurence occurence) {
		this.occurence = occurence;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public Evenement getEvenement(Occurence occurence) {
		return facade.getServiceCommande().FindEvenementByOccurence(occurence);
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public String getMoisExpiration() {
		return moisExpiration;
	}

	public void setMoisExpiration(String moisExpiration) {
		this.moisExpiration = moisExpiration;
	}

	public String getAnneeExpiration() {
		return anneeExpiration;
	}

	public void setAnneeExpiration(String anneeExpiration) {
		this.anneeExpiration = anneeExpiration;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getCrypto() {
		return crypto;
	}

	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public List<OccurenceDto> getListOccurences() {
		return listOccurences;
	}

	public void setListOccurences(List<OccurenceDto> listOccurences) {
		this.listOccurences = listOccurences;
	}

	public boolean isPaiementEchec() {
		return paiementEchec;
	}

	public void setPaiementEchec(boolean paiementEchec) {
		this.paiementEchec = paiementEchec;
	}

	public int getNbrPlaceReal() {
		return nbrPlaceReal;
	}

	public void setNbrPlaceReal(int nbrPlaceReal) {
		this.nbrPlaceReal = nbrPlaceReal;
	}

	public Map<Integer, Integer> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}
}
