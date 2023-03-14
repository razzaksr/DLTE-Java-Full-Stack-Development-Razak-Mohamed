package businesslogic;

import javax.xml.ws.Endpoint;

public class ExecuteExndPoints {
    private static String url="http://localhost:8082/dlte";
    public static void main(String[] args) {
        BankTransactions bankTransactions=new BankTransactions();
        System.out.println("Webservice running on "+url);
        Endpoint.publish(url,bankTransactions);

    }
}
