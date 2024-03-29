
package fr.afcepf.al28.ticketshack.bpel;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "processTicketsHack", targetNamespace = "http://bpel.ticketshack.al28.afcepf.fr", wsdlLocation = "http://localhost:9090/ode/processes/processTicketsHack?wsdl")
public class ProcessTicketsHack
    extends Service
{

    private final static URL PROCESSTICKETSHACK_WSDL_LOCATION;
    private final static WebServiceException PROCESSTICKETSHACK_EXCEPTION;
    private final static QName PROCESSTICKETSHACK_QNAME = new QName("http://bpel.ticketshack.al28.afcepf.fr", "processTicketsHack");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/ode/processes/processTicketsHack?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PROCESSTICKETSHACK_WSDL_LOCATION = url;
        PROCESSTICKETSHACK_EXCEPTION = e;
    }

    public ProcessTicketsHack() {
        super(__getWsdlLocation(), PROCESSTICKETSHACK_QNAME);
    }

    public ProcessTicketsHack(WebServiceFeature... features) {
        super(__getWsdlLocation(), PROCESSTICKETSHACK_QNAME, features);
    }

    public ProcessTicketsHack(URL wsdlLocation) {
        super(wsdlLocation, PROCESSTICKETSHACK_QNAME);
    }

    public ProcessTicketsHack(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PROCESSTICKETSHACK_QNAME, features);
    }

    public ProcessTicketsHack(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProcessTicketsHack(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProcessTicketsHackPortType
     */
    @WebEndpoint(name = "processTicketsHackPort")
    public ProcessTicketsHackPortType getProcessTicketsHackPort() {
        return super.getPort(new QName("http://bpel.ticketshack.al28.afcepf.fr", "processTicketsHackPort"), ProcessTicketsHackPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProcessTicketsHackPortType
     */
    @WebEndpoint(name = "processTicketsHackPort")
    public ProcessTicketsHackPortType getProcessTicketsHackPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bpel.ticketshack.al28.afcepf.fr", "processTicketsHackPort"), ProcessTicketsHackPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PROCESSTICKETSHACK_EXCEPTION!= null) {
            throw PROCESSTICKETSHACK_EXCEPTION;
        }
        return PROCESSTICKETSHACK_WSDL_LOCATION;
    }

}
