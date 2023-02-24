package exceptions.dlte.javapart.handlings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementingWithAssertion {
    public static void main(String[] args) {
        int loanAmount=0,tenure=0;
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.println("Enter the required loan amount");
            loanAmount=scanner.nextInt();
            tenure=scanner.nextInt();
            assert tenure!=0:"can't provide loan";
            loanAmount+=(int)(loanAmount*0.150);
            System.out.println(loanAmount/tenure+" is EMI for the loan with interest "+loanAmount);
        }
        catch(ArithmeticException | AssertionError arith){
            System.out.println(arith);
            System.out.println("Tenure shouldn't ZERO");
            tenure=scanner.nextInt();
            loanAmount+=(int)(loanAmount*0.150);
            System.out.println(loanAmount/tenure+" is EMI for the loan with interest "+loanAmount);
        }
        catch (InputMismatchException inputs){
            System.out.println(inputs);
            Scanner scanner1=new Scanner(System.in);
            tenure=scanner1.nextInt();
            loanAmount+=(int)(loanAmount*0.150);
            System.out.println(loanAmount/tenure+" is EMI for the loan with interest "+loanAmount);
        }
    }
}
