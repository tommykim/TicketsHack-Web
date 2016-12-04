package fr.afcepf.al27.ticketshack.front.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;

@Component("mBIndex")
public class MBIndex {

	@Autowired
	private IFacade facade;
	
	private Evenement evenement; // provisoir pour eviter le nullPointerExcep
	
	public String fonction() {
		evenement = facade.getServiceEvenement().getEvenementById(1);
		return null;
	}

	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public IFacade getFacade() {
		return facade;
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
}
