package exceptions.dlte.javapart.handlings;

import java.util.Arrays;
import java.util.Scanner;

public class ImplementingUserDefined {
    public static void main(String[] args) {
        String[] availableLoans={"Auto","Personal","Business","Home","LAP"};
        Scanner scanner=new Scanner(System.in);
        String userRequired="";

        try{
            System.out.println("Enter the desired loan to apply ");
            userRequired=scanner.nextLine();
            boolean found=Arrays.toString(availableLoans).contains(userRequired);
            assert found:"Invalid Loan";
            if(found){
                System.out.println(userRequired+" available and apply the loan");
            }
            else{
                throw new LoanException();
            }
        }
        catch (LoanException|AssertionError lException){
            System.out.println(lException);
            System.out.println("Enter the desired loan to apply ");
            userRequired=scanner.nextLine();
            if(Arrays.toString(availableLoans).contains(userRequired)){
                System.out.println(userRequired+" available and apply the loan");
            }
            else{
                System.out.println("Maximum attempt made try after some time");
            }
        }
    }
}
