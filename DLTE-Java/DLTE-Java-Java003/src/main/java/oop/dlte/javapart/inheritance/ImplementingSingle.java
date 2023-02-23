package oop.dlte.javapart.inheritance;

import java.util.Arrays;

public class ImplementingSingle extends Performing {

    public void traverse(){
        for(int index=0;index<lockers.length;index++){
            Arrays.sort(lockers[index]);
            System.out.println(Arrays.toString(lockers[index]));
        }
    }

    public void sumLocker(){
        int worthAmount=0;
        for(int[] row:lockers){
            for(int each:row){
                worthAmount+=each;
            }
        }
        super.traverse();
        System.out.println("Total worth of bank locker "+worthAmount);
    }

    public static void main(String[] args) {
        //Performing perform=new Performing();
        ImplementingSingle perform=new ImplementingSingle();
        perform.traverse();// runtime poly/ dynamic
        perform.sumLocker();
    }
}

class Performing{
    // array[row][column] >> where row and column indices always starts with 0
    // lockers[0]   >> 0th row >> {34500,12000,80000}
    // lockers.length >> no of rows
    // 23000 >> 1th row,1th column
    // 34000 >> 2,1
    int[][] lockers={{34500,12000,80000},{4500,23000,10000},{7600,34000,12000}};

    public void traverse(){
        for(int[] row:lockers){
            for(int each:row){
                System.out.print(each+" ");
            }
            System.out.println("\nLocker is checked\n");
        }
    }
}