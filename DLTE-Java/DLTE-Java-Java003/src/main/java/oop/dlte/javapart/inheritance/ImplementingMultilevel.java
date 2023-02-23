package oop.dlte.javapart.inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

public class ImplementingMultilevel extends DebCard{

    public void payBills(String toWhom, int amount){
        if(getAccBal()>=amount){
            setAccBal(getAccBal()-amount);
            System.out.println(amount+" Billing to "+toWhom+" has paid by "+getAccHolder());
        }
        else{
            System.out.println(amount+" Billing to "+toWhom+" hasn't paid by "+getAccHolder()+" since insufficient balance");
        }
    }

    public static void main(String[] args) {
        ImplementingMultilevel implement=new ImplementingMultilevel();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the account details such as holder name, accnum, accbalance");

        implement.setAccHolder(scanner.nextLine());
        implement.setAccNum(scanner.nextLong());implement.setAccBal(scanner.nextDouble());
        implement.deposit(34000);
        implement.payBills("electricity",31000);
        implement.withdraw(10000);
        System.out.println(implement);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class KYC{
    private String accHolder;
    private long accNum;
    private double accBal;
}

class DebCard extends KYC{
    public void deposit(int amount){
        setAccBal(getAccBal()+amount);
        System.out.println(amount+" has deposited in "+getAccHolder()+" account");
    }
    public void withdraw(int amount){
        if(getAccBal()>=amount){
            setAccBal(getAccBal()-amount);
            System.out.println(amount+" has withdrawn from "+getAccNum()+" account");
        }
        else{
            System.out.println(amount+" hasn't withdrawn from "+getAccNum()+" account since insufficient balance");
        }
    }
}