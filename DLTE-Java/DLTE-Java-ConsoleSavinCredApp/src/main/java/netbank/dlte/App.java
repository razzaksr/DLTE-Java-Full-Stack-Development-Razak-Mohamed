package netbank.dlte;

import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        SavinCredBank bank=new SavinCredBank();
        String processSelection="";
        int userSelection=0;

        do{
            System.out.println("----------------Welcome to SavinCred Bank-----------");
            System.out.println("1. Want to be our customer\n2.Login\n3.Exit");
            userSelection=scanner.nextInt();
            switch (userSelection){
                case 1:
                    bank.openAccount();
                    bank.report();
                    break;
                case 2:
                    System.out.println("-------------Welcome back --------------");
                    System.out.println("Enter the username");
                    String userName= scanner.next();
                    if(bank.getCustomers().containsKey(userName)){
                        KYC kyc=bank.getCustomers().get(userName);
                        System.out.println("Enter the password ");
                        String pass= scanner.next();
                        if(kyc.getPassword().equals(pass)){
                            boolean isLogged=true;
                            do{
                                System.out.println("Deposit\nWithdraw\nUpdate\nTransfer\nStatement\nEnquiry\nLogout");
                                processSelection=scanner.next();
                                switch (processSelection){
                                    case "deposit": case "Deposit":
                                        System.out.println("Enter the amount to deposited");
                                        bank.deposit(kyc, scanner.nextInt(), new Date());
                                        break;
                                    case "withdraw": case "Withdraw":
                                        System.out.println("Enter the amount to withdraw");
                                        bank.withdraw(kyc, scanner.nextInt(), new Date());
                                        break;
                                    case "Transfer": case "transfer":
                                        System.out.println("Enter the amount to transfer and payee name");
                                        bank.transfer(kyc, scanner.nextInt(), scanner.next());
                                        break;
                                    case "statement": case "Statement":
                                        bank.statement(kyc);
                                        break;
                                    case "enquiry": case "Enquiry":System.out.println(kyc);break;
                                    default:isLogged=false;
                                }
                            }while(isLogged);
                        }
                        else{
                            System.out.println("Unauthorised user");
                            break;
                        }
                    }
                    break;
                default:return;
            }
        }while (true);
    }
}
