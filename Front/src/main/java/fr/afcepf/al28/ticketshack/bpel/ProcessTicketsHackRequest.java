
package fr.afcepf.al28.ticketshack.bpel;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeResa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroCarte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="crypto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateExpiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listeResa",
    "numeroCarte",
    "crypto",
    "dateExpiration",
    "montant"
})
@XmlRootElement(name = "processTicketsHackRequest")
public class ProcessTicketsHackRequest {

    @XmlElement(required = true)
    protected String listeResa;
    @XmlElement(required = true)
    protected String numeroCarte;
    @XmlElement(required = true)
    protected String crypto;
    @XmlElement(required = true)
    protected String dateExpiration;
    @XmlElement(required = true)
    protected BigInteger montant;

    /**
     * Obtient la valeur de la propriété listeResa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListeResa() {
        return listeResa;
    }

    /**
     * Définit la valeur de la propriété listeResa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListeResa(String value) {
        this.listeResa = value;
    }

    /**
     * Obtient la valeur de la propriété numeroCarte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCarte() {
        return numeroCarte;
    }

    /**
     * Définit la valeur de la propriété numeroCarte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCarte(String value) {
        this.numeroCarte = value;
    }

    /**
     * Obtient la valeur de la propriété crypto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrypto() {
        return crypto;
    }

    /**
     * Définit la valeur de la propriété crypto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrypto(String value) {
        this.crypto = value;
    }

    /**
     * Obtient la valeur de la propriété dateExpiration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Définit la valeur de la propriété dateExpiration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpiration(String value) {
        this.dateExpiration = value;
    }

    /**
     * Obtient la valeur de la propriété montant.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMontant() {
        return montant;
    }

    /**
     * Définit la valeur de la propriété montant.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMontant(BigInteger value) {
        this.montant = value;
    }

}
