package fr.afcepf.al27.ticketshack.apidao.apidao;

import java.util.List;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

public interface IDaoTheme {
	
	public void insert(Theme theme);
	public void update(Theme theme);
	public Theme findById(int idTheme);
	public List<Theme> findAll();
	public void delete(Theme theme);
	List<Theme> findThemeByCategory (Categorie categorie);
	
}
