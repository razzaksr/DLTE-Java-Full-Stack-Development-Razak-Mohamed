package netbank.dlte;

import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Data
public class SavinCredBank implements SavinCredRemote{

    private Scanner scanner=new Scanner(System.in);
    private Map<String,KYC> customers=new TreeMap<>();

    @Override
    public String openAccount() {
        System.out.println("Enter the username ");
        String user= scanner.next();

        if(customers.containsKey(user)){
            System.out.println("Choose different username");
            user= scanner.next();
        }
        System.out.println("Enter the password ");
        String pass= scanner.next();
        if(!pass.matches("(?=.*[0-9])(?=.*[$#@!*])[a-zA-Z0-9$#@!*]{8,}")){
            System.out.println("Enter the password with atleast 8 characters combination of alpha,digit and specials");
            pass= scanner.next();
        }
        System.out.println("Enter the details address, email, contact, balance ");
        KYC kyc=new KYC(user,pass, scanner.next(), scanner.next(), scanner.nextLong(), scanner.nextDouble());
        kyc.setDateOfOpened(new Date());
        writeStatements(kyc,user+" has opened account with "+ kyc.getBalance()+" on "+kyc.getDateOfOpened());
        customers.put(kyc.getUsername(), kyc);
        return "Account has opened";
    }

    public void report(){
        System.out.println(customers);
    }

    @Override
    public void deposit(KYC kyc,int amount, Date date) {
        kyc.setBalance(kyc.getBalance()+amount);
        writeStatements(kyc,amount+" has credited on "+date);
    }

    @Override
    public boolean withdraw(KYC kyc,int amount, Date date) {
        if((kyc.getBalance()-5000)>amount){
            kyc.setBalance(kyc.getBalance()-amount);
            writeStatements(kyc,amount+" has debited on "+date);
            return true;
        }
        else{
            System.out.println("Insufficient fund in account");
            return false;
        }
    }

    @Override
    public void update(KYC kyc) {

    }

    public void statement(KYC kyc){
        kyc.getTransactions().forEach(System.out::println);
    }

    @Override
    public void writeStatements(KYC kyc,String process) {
        kyc.getTransactions().add(0,process);
    }

    @Override
    public void transfer(KYC kyc,int amount, String payeeName) {
        if(customers.containsKey(payeeName)){
            KYC payee=customers.get(payeeName);
            if(withdraw(kyc,amount,new Date())){
                deposit(payee,amount,new Date());
                System.out.println("Transfer done");
            }
        }
        else{
            System.out.println("Invalid payee");
        }
    }
}
