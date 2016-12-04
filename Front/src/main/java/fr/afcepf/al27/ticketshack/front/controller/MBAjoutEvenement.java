package fr.afcepf.al27.ticketshack.front.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.primefaces.model.UploadedFile;

import fr.afcepf.al27.ticketshack.apiservice.apifacade.IFacade;
import fr.afcepf.al27.ticketshack.entity.entity.Categorie;
import fr.afcepf.al27.ticketshack.entity.entity.Evenement;
import fr.afcepf.al27.ticketshack.entity.entity.Occurence;
import fr.afcepf.al27.ticketshack.entity.entity.Theme;
import fr.afcepf.al27.ticketshack.front.util.XmlImport;

@ManagedBean(name = "mbAjoutEvenement")
@SessionScoped
public class MBAjoutEvenement {

	@ManagedProperty(value = "#{facade}")
	private IFacade facade;
	
	public IFacade getFacade() {
		return facade;
	}
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
	
	private Evenement evenement = new Evenement();
	
//	@PostConstruct
//	public void init() {
//		//evenement.setCategorie(new Categorie(null, "")); // Pour l'Input JSF		
//	}
	public void reinitialiser() {
		evenement = new Evenement();
	}
	public void parserXml(File file) {
		Evenement newEvenement = XmlImport.parseEvenement(file);
		if(newEvenement != null) {
			evenement.setCategorie(
					facade.getServiceRecherche().findCategorieById(newEvenement.getCategorie().getIdCategorie()));
			evenement.setLibelleEvenement(newEvenement.getLibelleEvenement());
			evenement.setDescriptif(newEvenement.getDescriptif());
			evenement.setOccurences(newEvenement.getOccurences());
			evenement.setThemes(newEvenement.getThemes());
			evenement.setParution(new Date());
			evenement.setAffiche(newEvenement.getAffiche());
			for(Occurence occurence : evenement.getOccurences()) {
				occurence.setEvenement(evenement);
			}
			for(Theme theme : evenement.getThemes()) {
				theme = facade.getServiceRecherche().findThemeById(theme.getIdTheme());
				theme.setEvenements(facade.getServiceRecherche().findEvenementsByTheme(theme));
				theme.getEvenements().add(evenement);
			}
		}
	}
	
	public void ajouterEvenement() {
		facade.getServiceEvenement().enregistrerEvenement(evenement);
		reinitialiser();
	}
	
	public String uploadXmlFile() {
		File file = uploadFile();
		if(file != null) {
        	parserXml(file);
        }
		return null;
	}
	
	public String uploadImgFile() {
		File file = uploadFile();
		if(file != null) {
			evenement.setAffiche(file.getName());
		}
		return null;
	}
	public File uploadFile() {  
//        System.out.println("uploadFile..");  
        HttpServletRequest req = (HttpServletRequest) 
        		FacesContext.getCurrentInstance().getExternalContext().getRequest();  
//        System.out.println(req.getAttribute("fichierupload"));
        List<DiskFileItem> params = (List<DiskFileItem>) req.getAttribute("fichierupload");
        File f = null;
//        System.out.println("SIZE PARMS: " + params.size());
        for (DiskFileItem dfi : params) {
//        	System.out.println("CharSet: " + dfi.getCharSet());
//        	System.out.println("FieldName: " + dfi.getFieldName());
//        	System.out.println("ContentType: " + dfi.getContentType());
//			System.out.println("NAME: " + dfi.getName());
			if(dfi.getName().isEmpty()) {
				return null;
			}
			// chemin de la classe : 
			/*
			 * /path/to/server/standalone/deployments/PROJET/WEB-INF/classes/packages 
			 */
//			System.out.println(this.getClass());
//			System.out.println("getRessource: " + this.getClass().getResource(""));
			String path = this.getClass().getResource("").getPath();
			path = path.split("/WEB-INF")[0];			
//			System.out.println("path: " + path);
			// Si c'est une image, on le met dans le dossier Images !
//			System.out.println("Content TYPE: |" + dfi.getContentType() + "|");
			if(dfi.getContentType().equals("image/jpeg")) {
				path += "/images";
//				System.out.println("New PATH: " + path);
			}
			f = new File(path + "/" + dfi.getName());
///* pour dev */			String path2 = "C:/Users/Stagiaire/Desktop/03.11.15/Inventor-Web2/src/main/webapp";
///* pour dev */			File f2 = new File(path2 + "/" + dfi.getName());
//			System.out.println(f.getAbsolutePath());
			try {
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(dfi.get());
				fos.close();
//				/* pour dev */				FileOutputStream fos2 = new FileOutputStream(f2);
//				/* pour dev */				fos2.write(dfi.get());
//				/* pour dev */				fos2.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
        return f;  
    } 
	
	
	
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	
}
