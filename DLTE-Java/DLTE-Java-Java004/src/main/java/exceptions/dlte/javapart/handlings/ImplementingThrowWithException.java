package exceptions.dlte.javapart.handlings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementingThrowWithException {
    String[] availableLoans={"Auto","Personal","Business","Home","LAP"};

    public void selectLoan(int index){
        try{
            System.out.println("User has chosen the loan to apply is "+availableLoans[index]);
        }
        catch(ArrayIndexOutOfBoundsException aObject){
            System.out.println(aObject);
            throw aObject;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int position=0;
        ImplementingThrowWithException object=new ImplementingThrowWithException();

        try{
            System.out.println("Select loan by index ");
            position= scanner.nextInt();
            object.selectLoan(position);
        }
        catch (ArrayIndexOutOfBoundsException aError){
            System.out.println(aError+" in main block");
            System.out.println("Enter the index in number format and within "+object.availableLoans.length);
            position= scanner.nextInt();
            object.selectLoan(position);
        }
        catch (InputMismatchException ins){
            System.out.println(ins);
            Scanner newScanner=new Scanner(System.in);
            System.out.println("Enter the index in number format");
            position= newScanner.nextInt();
            object.selectLoan(position);
        }

        scanner.close();
    }
}
