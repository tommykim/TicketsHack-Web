
package fr.afcepf.al28.webservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reserverLesPlaces complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reserverLesPlaces">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listACheker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverLesPlaces", propOrder = {
    "listACheker"
})
public class ReserverLesPlaces {

    protected String listACheker;

    /**
     * Obtient la valeur de la propriété listACheker.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListACheker() {
        return listACheker;
    }

    /**
     * Définit la valeur de la propriété listACheker.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListACheker(String value) {
        this.listACheker = value;
    }

}
