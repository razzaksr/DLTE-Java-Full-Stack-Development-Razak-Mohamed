package webservice.client.dlte;

import businesslogic.BankTransactionsService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        businesslogic.BankTransactionsService service=new BankTransactionsService();
        businesslogic.BankTransactions bank=service.getBankTransactionsPort();
        System.out.println(bank.read(4));
        System.out.println(bank.search(545));
        System.out.println(bank.search(543));
    }
}
