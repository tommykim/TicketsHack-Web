
package fr.afcepf.al28.webservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour annulerLesPlacesReservees complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="annulerLesPlacesReservees">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listAAnnuler" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annulerLesPlacesReservees", propOrder = {
    "listAAnnuler"
})
public class AnnulerLesPlacesReservees {

    protected String listAAnnuler;

    /**
     * Obtient la valeur de la propriété listAAnnuler.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAAnnuler() {
        return listAAnnuler;
    }

    /**
     * Définit la valeur de la propriété listAAnnuler.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAAnnuler(String value) {
        this.listAAnnuler = value;
    }

}
