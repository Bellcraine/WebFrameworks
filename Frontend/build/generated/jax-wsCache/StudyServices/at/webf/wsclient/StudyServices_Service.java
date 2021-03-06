
package at.webf.wsclient;

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
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StudyServices", targetNamespace = "http://ws.at/", wsdlLocation = "http://localhost:8080/Backend/StudyServices?wsdl")
public class StudyServices_Service
    extends Service
{

    private final static URL STUDYSERVICES_WSDL_LOCATION;
    private final static WebServiceException STUDYSERVICES_EXCEPTION;
    private final static QName STUDYSERVICES_QNAME = new QName("http://ws.at/", "StudyServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Backend/StudyServices?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STUDYSERVICES_WSDL_LOCATION = url;
        STUDYSERVICES_EXCEPTION = e;
    }

    public StudyServices_Service() {
        super(__getWsdlLocation(), STUDYSERVICES_QNAME);
    }

    public StudyServices_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), STUDYSERVICES_QNAME, features);
    }

    public StudyServices_Service(URL wsdlLocation) {
        super(wsdlLocation, STUDYSERVICES_QNAME);
    }

    public StudyServices_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STUDYSERVICES_QNAME, features);
    }

    public StudyServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudyServices_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StudyServices
     */
    @WebEndpoint(name = "StudyServicesPort")
    public StudyServices getStudyServicesPort() {
        return super.getPort(new QName("http://ws.at/", "StudyServicesPort"), StudyServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudyServices
     */
    @WebEndpoint(name = "StudyServicesPort")
    public StudyServices getStudyServicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.at/", "StudyServicesPort"), StudyServices.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STUDYSERVICES_EXCEPTION!= null) {
            throw STUDYSERVICES_EXCEPTION;
        }
        return STUDYSERVICES_WSDL_LOCATION;
    }

}
