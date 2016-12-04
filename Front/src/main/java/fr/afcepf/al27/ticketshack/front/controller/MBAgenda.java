package fr.afcepf.al27.ticketshack.front.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;


@ManagedBean(name = "mbAgenda")
@SessionScoped
public class MBAgenda implements Serializable {
	

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion mbConnexion;
	
	private Utilisateur utilisateur;
	
	private ScheduleModel lazyEventModel;
	
	@PostConstruct
    public void init() {
		utilisateur = mbConnexion.getUtilisateur();
				
		final List<Occurence> liste = facade.getServiceCompte().findOccurencesbyUtilisateur(utilisateur);
		lazyEventModel = new LazyScheduleModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void loadEvents(Date start, Date end) {
            	for (Occurence o: liste) {
            		addEvent((ScheduleEvent) new DefaultScheduleEvent(facade.getServiceCompte().getLibelleEvenementByOccurence(o),
            				o.getDate(), o.getDate()) );	
				}
            }   
        };
    }
	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}
	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}
	public MBConnexion getMbConnexion() {
		return mbConnexion;
	}
	public void setMbConnexion(MBConnexion mbConnexion) {
		this.mbConnexion = mbConnexion;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
