package host;

import javax.xml.ws.Endpoint;

public class ExecuteEnd {
    private static String url="http://localhost:8082/crudl";
    public static void main(String[] args) {
        KycCRUDL kycCRUDL=new KycCRUDL();
        System.out.println("Webservice is running on "+url);
        Endpoint.publish(url,kycCRUDL);
    }
}
