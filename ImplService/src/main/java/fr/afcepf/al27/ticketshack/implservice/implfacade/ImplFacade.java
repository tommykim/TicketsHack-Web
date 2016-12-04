package fr.afcepf.al27.ticketshack.implservice.implfacade;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCommande;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceCompte;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceEvenement;
import fr.afcepf.al27.ticketshack.apiservice.apiservice.IServiceRecherche;



@Component("facade")
public class ImplFacade implements IFacade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IServiceEvenement serviceEvenement;
	
	@Autowired
	private IServiceCompte serviceCompte;
	
	@Autowired
	private IServiceRecherche serviceRecherche;
	
	@Autowired
	private IServiceCommande serviceCommande;
	
	
	@Override
	public IServiceEvenement getServiceEvenement() {
		return serviceEvenement;
	}

	@Override
	public IServiceCompte getServiceCompte() {
		return serviceCompte;
	}
	
	@Override
	public IServiceRecherche getServiceRecherche() {
		return serviceRecherche;
	}

	@Override
	public IServiceCommande getServiceCommande() {
		return serviceCommande;
	}

	/*public IserviceResaSoapApi getServiceSoapApi() {
		serviceSoapApi = new ServiceResaSoapImplService().getServiceResaSoapImplPort();
		return serviceSoapApi;
	}*/

	
}
