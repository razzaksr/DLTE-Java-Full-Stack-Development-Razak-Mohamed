package basic.dlte.javapart;

import java.util.Scanner;

public class ImplementingArray {
    public static void main(String[] args) {
        String[] beneficiaries={"Manvith","Garouv","Surya","Ukiyo","Abishek","Garouv"
                ,"Apoorva","Sridhar","Arun","Srikanth","Arun","Garouv"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the beneficiar name");
        String myParticular=scanner.nextLine();

        ImplementingArray implement=new ImplementingArray();
        int total=implement.occurance(beneficiaries,myParticular);
        System.out.println(total+" is number of times made transaction to "+myParticular);
    }
    public int occurance(String[] myArray,String desiredName){
        int count=0;
        // iterate
        for(int index=0;index<myArray.length;index++){
            if(myArray[index].equalsIgnoreCase(desiredName)){
                count++;
            }
        }
        return count;
    }
}
