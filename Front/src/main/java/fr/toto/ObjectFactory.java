
package fr.toto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.toto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VerifierCarteResponse_QNAME = new QName("http://toto.fr", "verifierCarteResponse");
    private final static QName _VerifierCarte_QNAME = new QName("http://toto.fr", "verifierCarte");
    private final static QName _EnregistrerPaiementResponse_QNAME = new QName("http://toto.fr", "enregistrerPaiementResponse");
    private final static QName _EnregistrerPaiement_QNAME = new QName("http://toto.fr", "enregistrerPaiement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.toto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifierCarteResponse }
     * 
     */
    public VerifierCarteResponse createVerifierCarteResponse() {
        return new VerifierCarteResponse();
    }

    /**
     * Create an instance of {@link VerifierCarte }
     * 
     */
    public VerifierCarte createVerifierCarte() {
        return new VerifierCarte();
    }

    /**
     * Create an instance of {@link EnregistrerPaiementResponse }
     * 
     */
    public EnregistrerPaiementResponse createEnregistrerPaiementResponse() {
        return new EnregistrerPaiementResponse();
    }

    /**
     * Create an instance of {@link EnregistrerPaiement }
     * 
     */
    public EnregistrerPaiement createEnregistrerPaiement() {
        return new EnregistrerPaiement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifierCarteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toto.fr", name = "verifierCarteResponse")
    public JAXBElement<VerifierCarteResponse> createVerifierCarteResponse(VerifierCarteResponse value) {
        return new JAXBElement<VerifierCarteResponse>(_VerifierCarteResponse_QNAME, VerifierCarteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifierCarte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toto.fr", name = "verifierCarte")
    public JAXBElement<VerifierCarte> createVerifierCarte(VerifierCarte value) {
        return new JAXBElement<VerifierCarte>(_VerifierCarte_QNAME, VerifierCarte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnregistrerPaiementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toto.fr", name = "enregistrerPaiementResponse")
    public JAXBElement<EnregistrerPaiementResponse> createEnregistrerPaiementResponse(EnregistrerPaiementResponse value) {
        return new JAXBElement<EnregistrerPaiementResponse>(_EnregistrerPaiementResponse_QNAME, EnregistrerPaiementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnregistrerPaiement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://toto.fr", name = "enregistrerPaiement")
    public JAXBElement<EnregistrerPaiement> createEnregistrerPaiement(EnregistrerPaiement value) {
        return new JAXBElement<EnregistrerPaiement>(_EnregistrerPaiement_QNAME, EnregistrerPaiement.class, null, value);
    }

}
