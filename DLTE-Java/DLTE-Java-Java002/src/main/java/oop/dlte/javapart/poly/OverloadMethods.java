package oop.dlte.javapart.poly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class OverloadMethods {
    public static void main(String[] args) {
        Transfer myAccount=new Transfer(87656789876L,23450.2);
        myAccount.fundTransfer("Sabari",20000,"rtgs");
        myAccount.fundTransfer("Sabari","rtgs",50000);
        myAccount.fundTransfer("Sabari","imps",23450);
        myAccount.fundTransfer("Sabari","imps",23445);

        myAccount.fundTransfer();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Transfer{
    private long accNum;
    private double accBal;


    public void fundTransfer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount to transfer within the daily limit of 5000rs");
        double amount= scanner.nextDouble();
        if(amount<=accBal){
            accBal-=amount;
            System.out.println(amount+" Fund transferred successfully");
        }
        else{
            System.out.println("Insufficient fund in account");
        }
        scanner.close();
    }

    public void fundTransfer(String beneficiar, int amount,String mode){
        if(mode.equalsIgnoreCase("rtgs")){
            if(amount>=50000&&amount<=accBal){
                accBal-=amount;
                System.out.println(amount+" to "+beneficiar+" transferred in the mode of "+mode);
            }
            else{
                System.out.println("Invalid transfer amount for RTGS");
            }
        }
        else if(mode.equalsIgnoreCase("imps")){
            if((amount+5)<=accBal){
                accBal-=(amount+5);
                System.out.println(amount+" to "+beneficiar+" transferred in the mode of "+mode);
            }
            else{
                System.out.println("Insufficient fund to make IMPS");
            }
        }
        else{
            if(amount<=accBal){
                accBal-=amount;
                System.out.println(amount+" to "+beneficiar+" transfer has initiated and will credit in 3 hours in the mode of "+mode);
            }
            else{
                System.out.println("Insufficient fund to make NEFT");
            }
        }
    }

    public void fundTransfer(String beneficiar, String mode, int amount){
        if(mode.equalsIgnoreCase("rtgs")){
            if(amount>=50000&&amount<=accBal){
                accBal-=amount;
                System.out.println(amount+" to "+beneficiar+" transferred in the mode of "+mode);
            }
            else{
                System.out.println("Invalid transfer amount for RTGS");
            }
        }
        else if(mode.equalsIgnoreCase("imps")){
            if((amount+5)<=accBal){
                accBal-=(amount+5);
                System.out.println(amount+" to "+beneficiar+" transferred in the mode of "+mode);
            }
            else{
                System.out.println("Insufficient fund to make IMPS");
            }
        }
        else{
            if(amount<=accBal){
                accBal-=amount;
                System.out.println(amount+" to "+beneficiar+" transfer has initiated and will credit in 3 hours in the mode of "+mode);
            }
            else{
                System.out.println("Insufficient fund to make NEFT");
            }
        }
    }
}