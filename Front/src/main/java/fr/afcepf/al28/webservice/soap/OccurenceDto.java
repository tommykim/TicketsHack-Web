
package fr.afcepf.al28.webservice.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour occurenceDto complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="occurenceDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_occurence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbPlaces" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "occurenceDto", propOrder = {
    "idOccurence",
    "nbPlaces"
})
public class OccurenceDto {

    @XmlElement(name = "id_occurence")
    protected int idOccurence;
    protected int nbPlaces;

    /**
     * Obtient la valeur de la propri�t� idOccurence.
     * 
     */
    public int getIdOccurence() {
        return idOccurence;
    }

    /**
     * D�finit la valeur de la propri�t� idOccurence.
     * 
     */
    public void setIdOccurence(int value) {
        this.idOccurence = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbPlaces.
     * 
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * D�finit la valeur de la propri�t� nbPlaces.
     * 
     */
    public void setNbPlaces(int value) {
        this.nbPlaces = value;
    }

}
