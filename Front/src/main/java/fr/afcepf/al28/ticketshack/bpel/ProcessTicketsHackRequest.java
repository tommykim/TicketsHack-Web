
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� listeResa.
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
     * D�finit la valeur de la propri�t� listeResa.
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
     * Obtient la valeur de la propri�t� numeroCarte.
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
     * D�finit la valeur de la propri�t� numeroCarte.
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
     * Obtient la valeur de la propri�t� crypto.
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
     * D�finit la valeur de la propri�t� crypto.
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
     * Obtient la valeur de la propri�t� dateExpiration.
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
     * D�finit la valeur de la propri�t� dateExpiration.
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
     * Obtient la valeur de la propri�t� montant.
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
     * D�finit la valeur de la propri�t� montant.
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
