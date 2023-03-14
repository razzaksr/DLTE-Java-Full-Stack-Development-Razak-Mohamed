
package businesslogic;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BankTransactions", targetNamespace = "http://businesslogic/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankTransactions {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://businesslogic/BankTransactions/readRequest", output = "http://businesslogic/BankTransactions/readResponse")
    public int read(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://businesslogic/BankTransactions/searchRequest", output = "http://businesslogic/BankTransactions/searchResponse")
    public int search(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

}
