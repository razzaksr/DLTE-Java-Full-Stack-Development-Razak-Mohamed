package oop.dlte.javapart.remotes;

import lombok.Data;

public class ImplementingMethodsOfLambda extends Applications {
    public static void main(String[] args) {
//        Operate operate=new Operate() {
//            @Override
//            public void insertNew(String name) {
//
//            }
//
//            @Override
//            public void filter(int start, int end) {
//
//            }
//        };
        Operate operate=((start, end) ->{
            for(int index=start;index<end;index++){
                System.out.println(Applications.todayRequests[index]);
            }
        });
        operate.filter(2,4);
    }
}

interface Operate{
    //public void insertNew(String name);
    void filter(int start,int end);
    //public abstract void filter(String phrase);
    //public abstract int linear(String name);
}


class Applications{
    //static String[] todayRequests=new String[10];
    static String[] todayRequests={"Razak","Sabari","Mohamed","Sridhar","Mani","Manvith","Surya"};
}