package netbank.dlte;

import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static File file=new File("savincred.doc");
    private static FileOutputStream fileOutputStream=null;
    private static ObjectOutputStream objectOutputStream=null;
    private static FileInputStream fileInputStream=null;
    private static ObjectInputStream objectInputStream=null;

    public static Map<String,KYC> readRecords(){
        try{
            fileInputStream =new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);

            Map<String,KYC> buffer = (Map<String, KYC>)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return buffer;
        }
        catch(IOException | ClassNotFoundException e){}
        return null;
    }

    public static void writeRecords(Map<String,KYC> customers){
        try{
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(customers);

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException io){}
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        SavinCredBank bank=new SavinCredBank();
        //bank.setCustomers(readRecords());
        String processSelection="";
        int userSelection=0;

        do{
            System.out.println("----------------Welcome to SavinCred Bank-----------");
            System.out.println("1. Want to be our customer\n2.Login\n3.Exit");
            userSelection=scanner.nextInt();
            switch (userSelection){
                case 1:
                    bank.setCustomers(readRecords());
                    bank.openAccount();
                    bank.report();
                    writeRecords(bank.getCustomers());
                    break;
                case 2:
                    System.out.println("-------------Welcome back --------------");
                    System.out.println("Enter the username");
                    String userName= scanner.next();
                    bank.setCustomers(readRecords());
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
                                        bank.setCustomers(readRecords());
                                        System.out.println("Enter the amount to deposited");
                                        bank.deposit(kyc, scanner.nextInt(), new Date());
                                        writeRecords(bank.getCustomers());
                                        break;
                                    case "withdraw": case "Withdraw":
                                        bank.setCustomers(readRecords());
                                        System.out.println("Enter the amount to withdraw");
                                        bank.withdraw(kyc, scanner.nextInt(), new Date());
                                        writeRecords(bank.getCustomers());
                                        break;
                                    case "Transfer": case "transfer":
                                        bank.setCustomers(readRecords());
                                        System.out.println("Enter the amount to transfer and payee name");
                                        bank.transfer(kyc, scanner.nextInt(), scanner.next());
                                        writeRecords(bank.getCustomers());
                                        break;
                                    case "statement": case "Statement":
                                        bank.setCustomers(readRecords());
                                        bank.statement(kyc);
                                        break;
                                    case "enquiry": case "Enquiry":
                                        bank.setCustomers(readRecords());
                                        System.out.println(kyc);
                                        break;
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
