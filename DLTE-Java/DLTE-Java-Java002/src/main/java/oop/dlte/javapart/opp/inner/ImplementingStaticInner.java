package oop.dlte.javapart.opp.inner;

import java.util.Arrays;

public class ImplementingStaticInner {
    public static void main(String[] args) {
        //System.out.println(Fund.mutual.length);
        System.out.println(Fund.getMutualCount());

        Fund.SelectFund select=new Fund.SelectFund();
        select.invest("Debt");
        select.invest("Bitcoin");

        Fund.SelectFund.availableFunds();

    }
}

// static inner class
class Fund{
    private static String[] mutual={"Equity","Index","Debt","Liquid"};
    public static int getMutualCount(){
        return mutual.length;
    }

    static class SelectFund{
        public static void availableFunds(){
            System.out.println(Arrays.toString(Fund.mutual));
        }
        public void invest(String desired){
            for(String pointer:mutual){
                if(pointer.equalsIgnoreCase(desired)){
                    System.out.println("The Customer has invested in "+desired);
                    return;
                }
            }
            System.out.println(desired+" mutual fund isn't available in the bank");
        }
    }
}