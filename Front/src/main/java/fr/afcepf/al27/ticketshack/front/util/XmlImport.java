package fr.afcepf.al27.ticketshack.front.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Departement;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Tarif;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;

public class XmlImport {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy/hh/mm");
	
	public static Evenement parseEvenement(File file) {

		Evenement evenementAjoute = new Evenement();
		List<Occurence> listeOccurences = evenementAjoute.getOccurences();
		List<Theme> listeThemes = evenementAjoute.getThemes();

		// PARSER
		// Charger le fichier en mémoire et créer l'arbre.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// Aller chercher la racine de l'arbre
//		System.out.println("-- Parse du Xml --");
		Element racine = document.getDocumentElement(); // Element "Evenement"
		
		NodeList attributs = racine.getChildNodes();
		int nombreAttributs = attributs.getLength();
//		System.out.println("Nb Attribut en Racine: " + nombreAttributs);
		for(int i=0; i<nombreAttributs; i++) {
			Node attribut = attributs.item(i);
			String nomAttribut = attribut.getNodeName();
			String valeurAttribut = attribut.getTextContent();
//			System.out.println("- Nom Attribut: " + nomAttribut);
//			System.out.println("- Valeur Attribut: " + valeurAttribut);
			if (nomAttribut.equals("categorie")) {
				evenementAjoute.setCategorie(new Categorie(
						Integer.parseInt(valeurAttribut), "inconnu"));
			}
			if (nomAttribut.equals("libelle")) {
				evenementAjoute.setLibelleEvenement(valeurAttribut);
			}
			if (nomAttribut.equals("descriptif")) {
				evenementAjoute.setDescriptif(valeurAttribut);
			}
			if (nomAttribut.equals("affiche")) {
				evenementAjoute.setAffiche(valeurAttribut);
			}
			
			if(nomAttribut.equals("themes")) {
				NodeList themes = attribut.getChildNodes();
				int nombreThemes = themes.getLength();
				for(int k=0; k<nombreThemes; k++) {
					Node theme = themes.item(k);
					if(theme.getNodeName().equals("theme")) {
						Theme newTheme = parserTheme(theme);
						listeThemes.add(newTheme);
					}
				}
			}
			if(nomAttribut.equals("occurences")) {
				NodeList occurences = attribut.getChildNodes();
				int nombreOccurences = occurences.getLength();
				for(int k=0; k<nombreOccurences; k++) {
					Node occurence = occurences.item(k);
					if(occurence.getNodeName().equals("occurence")) {
						Occurence newOccurence = parserOccurence(occurence);
						listeOccurences.add(newOccurence);
					}
				}
			}
			
		}
		return evenementAjoute;
	}
	
	private static Occurence parserOccurence(Node attribut) {
		Occurence occurence = new Occurence();
		List<Tarif> listeTarifs = occurence.getTarifs();
		NodeList attributsOccurence = attribut.getChildNodes();
		int nombreAttributsOccurence = attributsOccurence.getLength();
		for(int j=0; j<nombreAttributsOccurence; j++) {
			Node attributOccurence = attributsOccurence.item(j);
			String nomAttributOccurence = attributOccurence.getNodeName();
			String valeurAttributOccurence = attributOccurence.getTextContent();
			if(nomAttributOccurence.equals("departement")) {
				occurence.setDepartement(new Departement(
						Integer.parseInt(valeurAttributOccurence), "inconnu"));
			}
			if(nomAttributOccurence.equals("date")) {
				try {
					occurence.setDate(sdf.parse(valeurAttributOccurence));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(nomAttributOccurence.equals("lieu")) {
				occurence.setLieu(valeurAttributOccurence);
			}
			if(nomAttributOccurence.equals("nombrePlaces")) {
				occurence.setNombrePlaces(Integer.parseInt(valeurAttributOccurence));
			}
			if(nomAttributOccurence.equals("tarifs")) {
				NodeList tarifs = attributOccurence.getChildNodes();
				int nombreTarifs = tarifs.getLength();
//				System.out.println("Entré dans 'Tarifs': " + "nb: " + nombreTarifs);
				for(int k=0; k<nombreTarifs; k++) {
					Node tarif = tarifs.item(k);
					if(tarif.getNodeName().equals("tarif")) {
						Tarif newTarif = parserTarif(tarif);
						listeTarifs.add(newTarif);
						newTarif.setOccurence(occurence);
//						System.out.println("-------------------- Ajout d'un Tarif Effectué: " + newTarif.getLibelleTarif() + "/" + newTarif.getPrix());
					}
				}
			}
		}
		return occurence;
	}
	
	private static Theme parserTheme(Node attribut) {
		Theme theme = new Theme();
		theme.setIdTheme(
				Integer.parseInt(attribut.getTextContent()));
		return theme;
	}

	private static Tarif parserTarif(Node attribut) {
		Tarif tarif = new Tarif();
		NodeList attributsTarif = attribut.getChildNodes();
		int nombreAttributsTarif = attributsTarif.getLength();
		for(int j=0; j<nombreAttributsTarif; j++) {
			Node attributTarif = attributsTarif.item(j);
			String nomAttributTarif = attributTarif.getNodeName();
			String valeurAttributTarif = attributTarif.getTextContent();
			if(nomAttributTarif.equals("libelle")) {
				tarif.setLibelleTarif(valeurAttributTarif);
			}
			if(nomAttributTarif.equals("prix")) {
				tarif.setPrix(Long.parseLong(valeurAttributTarif));
			}
		}
		return tarif;
	}
}
