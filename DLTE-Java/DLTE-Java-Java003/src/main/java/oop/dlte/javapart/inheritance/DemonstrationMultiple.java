package oop.dlte.javapart.inheritance;

public class DemonstrationMultiple {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setAccBal(8900.4);
        customer.setAccHolder("Razak Mohamed");
        customer.setAccNum(876545678L);
        System.out.println(customer);
    }
}

class SMSBanking extends KYC{

}
class InternetBanking extends KYC{

}
//class Customer extends SMSBanking,InternetBanking{
class Customer extends SMSBanking{

}