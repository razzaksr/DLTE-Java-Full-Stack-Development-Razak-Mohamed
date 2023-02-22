package oop.dlte.javapart.opp.inner;

import java.util.Arrays;

public class ImplementingNonStaticInner {
    public static void main(String[] args) {
        Credit cred=new Credit();
        //cred.setCardNo(8765678945645L);
        cred.setLimit(55000);
        cred.setBilling(new int[]{3200,5600,3400,12000,500});

        Credit crud=new Credit();
        crud.setCardNo(678865456745L);
        crud.setLimit(25000);
        crud.setBilling(new int[]{800,12300,500,1200});

        //System.out.println(cred.getCardNo());

        Credit.Getter getter=cred.new Getter();

        // Arrays>> java.util

        System.out.println(Arrays.toString(getter.getBilling())+" "+getter.getCardNo());

        Credit.Getter gets=crud.new Getter();
        System.out.println(Arrays.toString(gets.getBilling())+" "+gets.getCardNo());

    }
}

// encapsulated class
class Credit{
    // private class member
    private long cardNo;
    private double limit;
    private int[] billing=new int[10];

    // setter, getter every private members

    //setter for cardNo
    public void setCardNo(long cardNo){
        // assigning local cardNo into class member cardNo
        // this refers current object which called the method
        this.cardNo=cardNo;
    }
    // setter for limit
    public void setLimit(double limit){this.limit=limit;}
    //setter for billing
    public void setBilling(int[] billing){this.billing=billing;}

    // non-static member class to Credit
    class Getter{
        // getter for cardNo
        public long getCardNo(){return cardNo;}

        //getter for limit
        public double getLimit(){return limit;}

        //getter for billing
        public int[] getBilling(){return billing;}
    }
}