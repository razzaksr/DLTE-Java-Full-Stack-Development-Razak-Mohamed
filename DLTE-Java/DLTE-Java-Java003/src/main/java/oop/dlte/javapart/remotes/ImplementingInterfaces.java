package oop.dlte.javapart.remotes;

import java.util.Arrays;

//public class ImplementingInterfaces implements Transmit{
public class ImplementingInterfaces implements Statement, Challan{
    public static void main(String[] args) {
        ImplementingInterfaces implement=new ImplementingInterfaces();
        implement.update();
        implement.linear(4.5);
        implement.fraction();
        Transmit.show();
//        implement.update();
//        implement.balance[1][0]=12.4;
//        Transmit.show();
    }

    @Override
    public void linear(double data) {
        for(int row=0;row<balance.length;row++){
            for(int column=0;column<balance[row].length;column++){
                if(balance[row][column]==data) {
                    System.out.println(data + " has found @row " + row + " and column " + column);
                    return;
                }
            }
        }
        System.out.println(data+" hasn't found");
    }

    // annual charges deducted from account
    @Override
    public void fraction() {
        for(int row=0;row<balance.length;row++){
            for(int column=0;column<balance[row].length;column++){
                balance[row][column]-=(balance[row][column]*0.050);
            }
        }
    }
}
interface Challan{
    // abstract method
    void fraction();
}