
package fr.afcepf.al28.webservice.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al28.webservice.soap package. 
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

    private final static QName _AnnulerLesPlacesReservees_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "annulerLesPlacesReservees");
    private final static QName _GetAllOccurenceByIdFilm_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "getAllOccurenceByIdFilm");
    private final static QName _ReserverLesPlaces_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "reserverLesPlaces");
    private final static QName _GetAllOccurenceByIdFilmResponse_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "getAllOccurenceByIdFilmResponse");
    private final static QName _NbrPlaceDispoByIdOccurenceResponse_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "nbrPlaceDispoByIdOccurenceResponse");
    private final static QName _ReserverLesPlacesResponse_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "reserverLesPlacesResponse");
    private final static QName _AnnulerLesPlacesReserveesResponse_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "annulerLesPlacesReserveesResponse");
    private final static QName _NbrPlaceDispoByIdOccurence_QNAME = new QName("http://soap.webservice.al28.afcepf.fr/", "nbrPlaceDispoByIdOccurence");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al28.webservice.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnnulerLesPlacesReservees }
     * 
     */
    public AnnulerLesPlacesReservees createAnnulerLesPlacesReservees() {
        return new AnnulerLesPlacesReservees();
    }

    /**
     * Create an instance of {@link ReserverLesPlaces }
     * 
     */
    public ReserverLesPlaces createReserverLesPlaces() {
        return new ReserverLesPlaces();
    }

    /**
     * Create an instance of {@link GetAllOccurenceByIdFilm }
     * 
     */
    public GetAllOccurenceByIdFilm createGetAllOccurenceByIdFilm() {
        return new GetAllOccurenceByIdFilm();
    }

    /**
     * Create an instance of {@link AnnulerLesPlacesReserveesResponse }
     * 
     */
    public AnnulerLesPlacesReserveesResponse createAnnulerLesPlacesReserveesResponse() {
        return new AnnulerLesPlacesReserveesResponse();
    }

    /**
     * Create an instance of {@link NbrPlaceDispoByIdOccurence }
     * 
     */
    public NbrPlaceDispoByIdOccurence createNbrPlaceDispoByIdOccurence() {
        return new NbrPlaceDispoByIdOccurence();
    }

    /**
     * Create an instance of {@link GetAllOccurenceByIdFilmResponse }
     * 
     */
    public GetAllOccurenceByIdFilmResponse createGetAllOccurenceByIdFilmResponse() {
        return new GetAllOccurenceByIdFilmResponse();
    }

    /**
     * Create an instance of {@link NbrPlaceDispoByIdOccurenceResponse }
     * 
     */
    public NbrPlaceDispoByIdOccurenceResponse createNbrPlaceDispoByIdOccurenceResponse() {
        return new NbrPlaceDispoByIdOccurenceResponse();
    }

    /**
     * Create an instance of {@link ReserverLesPlacesResponse }
     * 
     */
    public ReserverLesPlacesResponse createReserverLesPlacesResponse() {
        return new ReserverLesPlacesResponse();
    }

    /**
     * Create an instance of {@link OccurenceDto }
     * 
     */
    public OccurenceDto createOccurenceDto() {
        return new OccurenceDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerLesPlacesReservees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "annulerLesPlacesReservees")
    public JAXBElement<AnnulerLesPlacesReservees> createAnnulerLesPlacesReservees(AnnulerLesPlacesReservees value) {
        return new JAXBElement<AnnulerLesPlacesReservees>(_AnnulerLesPlacesReservees_QNAME, AnnulerLesPlacesReservees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOccurenceByIdFilm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "getAllOccurenceByIdFilm")
    public JAXBElement<GetAllOccurenceByIdFilm> createGetAllOccurenceByIdFilm(GetAllOccurenceByIdFilm value) {
        return new JAXBElement<GetAllOccurenceByIdFilm>(_GetAllOccurenceByIdFilm_QNAME, GetAllOccurenceByIdFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverLesPlaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "reserverLesPlaces")
    public JAXBElement<ReserverLesPlaces> createReserverLesPlaces(ReserverLesPlaces value) {
        return new JAXBElement<ReserverLesPlaces>(_ReserverLesPlaces_QNAME, ReserverLesPlaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOccurenceByIdFilmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "getAllOccurenceByIdFilmResponse")
    public JAXBElement<GetAllOccurenceByIdFilmResponse> createGetAllOccurenceByIdFilmResponse(GetAllOccurenceByIdFilmResponse value) {
        return new JAXBElement<GetAllOccurenceByIdFilmResponse>(_GetAllOccurenceByIdFilmResponse_QNAME, GetAllOccurenceByIdFilmResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NbrPlaceDispoByIdOccurenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "nbrPlaceDispoByIdOccurenceResponse")
    public JAXBElement<NbrPlaceDispoByIdOccurenceResponse> createNbrPlaceDispoByIdOccurenceResponse(NbrPlaceDispoByIdOccurenceResponse value) {
        return new JAXBElement<NbrPlaceDispoByIdOccurenceResponse>(_NbrPlaceDispoByIdOccurenceResponse_QNAME, NbrPlaceDispoByIdOccurenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverLesPlacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "reserverLesPlacesResponse")
    public JAXBElement<ReserverLesPlacesResponse> createReserverLesPlacesResponse(ReserverLesPlacesResponse value) {
        return new JAXBElement<ReserverLesPlacesResponse>(_ReserverLesPlacesResponse_QNAME, ReserverLesPlacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerLesPlacesReserveesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "annulerLesPlacesReserveesResponse")
    public JAXBElement<AnnulerLesPlacesReserveesResponse> createAnnulerLesPlacesReserveesResponse(AnnulerLesPlacesReserveesResponse value) {
        return new JAXBElement<AnnulerLesPlacesReserveesResponse>(_AnnulerLesPlacesReserveesResponse_QNAME, AnnulerLesPlacesReserveesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NbrPlaceDispoByIdOccurence }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.al28.afcepf.fr/", name = "nbrPlaceDispoByIdOccurence")
    public JAXBElement<NbrPlaceDispoByIdOccurence> createNbrPlaceDispoByIdOccurence(NbrPlaceDispoByIdOccurence value) {
        return new JAXBElement<NbrPlaceDispoByIdOccurence>(_NbrPlaceDispoByIdOccurence_QNAME, NbrPlaceDispoByIdOccurence.class, null, value);
    }

}
