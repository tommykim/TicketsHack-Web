package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.front.util.OccurenceDto;
import fr.afcepf.al27.ticketshack.front.util.ParseurJson;
import fr.afcepf.al27.ticketshack.front.util.TripletDeComparaison;

public class Test {

	@ManagedProperty(value = "#{facade}")
	private static IFacade facade;
	
	public static void main(String[] args) {
		List<Evenement> lesRecommandations = new ArrayList<Evenement>();
		//lesRecommandations.clear();
		List<TripletDeComparaison> listeObjetsLies = new ArrayList<>();
		int id = 1;

		//ID de l'évenement sur lequel on pointe
		

		try (BufferedReader br = new BufferedReader(new FileReader("Recommandations.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				TripletDeComparaison trip = new TripletDeComparaison();
				String[] tabVal = sCurrentLine.split(" , ");
				if ((Integer.parseInt(tabVal[0]) == id) && (Float.parseFloat(tabVal[2]) > 0.39)) {
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
			System.out.println(t.getIdCommandeCouplee());
			Evenement e = new Evenement(); 
			e = facade.getServiceEvenement().getEvenementById(t.getIdCommandeCouplee());
			lesRecommandations.add(e);
		}
		
		System.out.println(lesRecommandations.size());
	}
		
}
