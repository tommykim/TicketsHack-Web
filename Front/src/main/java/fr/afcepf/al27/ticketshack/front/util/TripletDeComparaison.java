package fr.afcepf.al27.ticketshack.front.util;

public class TripletDeComparaison {
	
	private int idCommandeRecherchee;
	private int idCommandeCouplee;
	private float pourcentageDeCouplage;
	public int getIdCommandeRecherchee() {
		return idCommandeRecherchee;
	}
	public void setIdCommandeRecherchee(int idCommandeRecherchee) {
		this.idCommandeRecherchee = idCommandeRecherchee;
	}
	public int getIdCommandeCouplee() {
		return idCommandeCouplee;
	}
	public void setIdCommandeCouplee(int idCommandeCouplee) {
		this.idCommandeCouplee = idCommandeCouplee;
	}
	public float getPourcentageDeCouplage() {
		return pourcentageDeCouplage;
	}
	public void setPourcentageDeCouplage(float pourcentageDeCouplage) {
		this.pourcentageDeCouplage = pourcentageDeCouplage;
	}
	public TripletDeComparaison() {
		// TODO Auto-generated constructor stub
	}
	public TripletDeComparaison(int idCommandeRecherchee, int idCommandeCouplee, float pourcentageDeCouplage) {
		this.idCommandeRecherchee = idCommandeRecherchee;
		this.idCommandeCouplee = idCommandeCouplee;
		this.pourcentageDeCouplage = pourcentageDeCouplage;
	}
	@Override
	public String toString() {
		return "TripletDeComparaison [idCommandeRecherchee=" + idCommandeRecherchee + ", idCommandeCouplee="
				+ idCommandeCouplee + ", pourcentageDeCouplage=" + pourcentageDeCouplage + "]";
	}
	
	

}
