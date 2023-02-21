package basic.dlte.javapart;

import java.util.Scanner;

public class CalculateFD {
    public static void main(String[] args) {

        Scanner scannerObject=new Scanner(System.in);

        // literal way object creation : Wrapper, String, Object
        Integer amount=0, duration=0;
        Double maturity=0.0, interest=6.4;

        System.out.println("Enter the Principle amount ");
        amount=scannerObject.nextInt();
        System.out.println("Enter the duration in years ");
        duration= scannerObject.nextInt();

        if(duration>1){
            maturity=amount+(amount*interest)/100;
            while(duration>1){
                maturity+=(maturity*interest)/100;
                duration--;
            }
            System.out.println(maturity+" is the money you get after "+duration+" years of "+amount+" invested");
        }
        else{
            System.out.println("Invalid Duration");
        }
    }
}
