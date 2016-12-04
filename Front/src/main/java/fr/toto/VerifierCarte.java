
package fr.toto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour verifierCarte complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="verifierCarte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroCarte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crypto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateExpiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifierCarte", propOrder = {
    "numeroCarte",
    "crypto",
    "dateExpiration"
})
public class VerifierCarte {

    protected String numeroCarte;
    protected String crypto;
    protected String dateExpiration;

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

}
