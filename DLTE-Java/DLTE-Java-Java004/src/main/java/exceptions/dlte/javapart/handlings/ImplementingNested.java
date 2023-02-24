package exceptions.dlte.javapart.handlings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementingNested {
    Scanner scanner=new Scanner(System.in);
    public void calculate(int loan,int months){
        try{
            loan+=(int)(loan*0.150);
            System.out.println(loan/months+" is EMI for the loan with interest "+loan);
        }
        catch (ArithmeticException ametic){
            throw ametic;
        }
    }
    public static void main(String[] args) {
        ImplementingNested nested=new ImplementingNested();
        int loanAmount=0,tenure=0;

        try{
            System.out.println("Enter the required loan amount");
            loanAmount=nested.scanner.nextInt();
            tenure=nested.scanner.nextInt();
            nested.calculate(loanAmount,tenure);
        }
        catch(ArithmeticException arith){
            System.out.println(arith);
            System.out.println("Tenure shouldn't ZERO");
            tenure=nested.scanner.nextInt();
            nested.calculate(loanAmount,tenure);
        }
        catch (InputMismatchException inputs){
            System.out.println(inputs);
            Scanner scanner1=new Scanner(System.in);
            try{
                loanAmount=scanner1.nextInt();
                tenure=scanner1.nextInt();
                nested.calculate(loanAmount,tenure);
            }
            catch(ArithmeticException aException){
                System.out.println("Enter the tenure in months except ZERO");
                tenure=scanner1.nextInt();
                nested.calculate(loanAmount,tenure);
            }
        }
        catch(Exception exe){
            System.out.println(exe);
        }
    }
}
