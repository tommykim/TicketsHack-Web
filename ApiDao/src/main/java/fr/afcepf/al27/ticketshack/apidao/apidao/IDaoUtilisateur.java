package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Theme;
import fr.afcepf.al27.ticketshack.entity.entity.Utilisateur;

public interface IDaoUtilisateur {

	public Utilisateur insert(Utilisateur utilisateur);
	public void update(Utilisateur utilisateur);
	public Utilisateur findById(int idUtilisateur);
	public List<Utilisateur> findAll();
	public void delete(Utilisateur utilisateur);
	public List<Utilisateur> findByMail(String mail);
	public List<Utilisateur> findByMailAndMdp(String mail, String mdp);
	public void setThemesByUtilisateur(Utilisateur ut, List<Theme> listeT);
	

	
}
