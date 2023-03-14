
package host;

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
@WebServiceClient(name = "KycCRUDLService", targetNamespace = "http://host/", wsdlLocation = "http://localhost:8082/crudl?wsdl")
public class KycCRUDLService
    extends Service
{

    private final static URL KYCCRUDLSERVICE_WSDL_LOCATION;
    private final static WebServiceException KYCCRUDLSERVICE_EXCEPTION;
    private final static QName KYCCRUDLSERVICE_QNAME = new QName("http://host/", "KycCRUDLService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/crudl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        KYCCRUDLSERVICE_WSDL_LOCATION = url;
        KYCCRUDLSERVICE_EXCEPTION = e;
    }

    public KycCRUDLService() {
        super(__getWsdlLocation(), KYCCRUDLSERVICE_QNAME);
    }

    public KycCRUDLService(WebServiceFeature... features) {
        super(__getWsdlLocation(), KYCCRUDLSERVICE_QNAME, features);
    }

    public KycCRUDLService(URL wsdlLocation) {
        super(wsdlLocation, KYCCRUDLSERVICE_QNAME);
    }

    public KycCRUDLService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, KYCCRUDLSERVICE_QNAME, features);
    }

    public KycCRUDLService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public KycCRUDLService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns KycCRUDL
     */
    @WebEndpoint(name = "KycCRUDLPort")
    public host.KycCRUDL getKycCRUDLPort() {
        return super.getPort(new QName("http://host/", "KycCRUDLPort"), host.KycCRUDL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns KycCRUDL
     */
    @WebEndpoint(name = "KycCRUDLPort")
    public host.KycCRUDL getKycCRUDLPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://host/", "KycCRUDLPort"), host.KycCRUDL.class, features);
    }

    private static URL __getWsdlLocation() {
        if (KYCCRUDLSERVICE_EXCEPTION!= null) {
            throw KYCCRUDLSERVICE_EXCEPTION;
        }
        return KYCCRUDLSERVICE_WSDL_LOCATION;
    }

}
