package basic.dlte.javapart;

import java.util.Scanner;

public class DemonstrateArray {
    public static void main(String[] args) {
        Double[] transactions=new Double[10];
        Scanner scannerObject=new Scanner(System.in);
        Integer noOfDebits=0;

        for(int index=0;index<transactions.length;index++){
            System.out.println("Current balance");
            transactions[index]=scannerObject.nextDouble();
            if(index>=1){
                if(transactions[index]<transactions[index-1])
                    noOfDebits++;
            }
        }
        System.out.println(noOfDebits+" debits occured");

        noOfDebits-=3;

        if(noOfDebits>0){
            System.out.println(noOfDebits*20+" charges for extra transaction of "+noOfDebits);
        }

        scannerObject.close();
    }
}
