package oop.dlte.javapart.remotes;

import java.util.Arrays;

public class ImplementingAbstracts {
    public static void main(String[] args) {
//        Transmit transmit=new Transmit() {};
//        Transmit.show();
//        transmit.update();
//        Transmit.show();
//        transmit.balance[0][1]=67.8;
//        Transmit.show();

        Statement state=new Statement() {
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
        };
        state.update();
        state.linear(4.5);
        state.linear(67.8);
        state.linear(89.4);
        Transmit.show();
    }
}

interface Statement extends Transmit{
    // abstract method
    void linear(double data);
}

// constructor not a part of interface
// private, public not allowed modifiers
// non static method as default
interface Transmit{
    // jagged
    double[][] balance={{3400.5,12300.5,89.4},{5690.3,1290.4}};
    // non-abstract static
    public static void show(){
        for(double[] row:balance){
            System.out.println(Arrays.toString(row));
        }
    }
    // non-abstract default
    default void update(){
        balance[0][0]=4.5;
    }
}