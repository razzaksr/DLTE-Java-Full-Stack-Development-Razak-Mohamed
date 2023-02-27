package store.dlte.javapart.generics;

import lombok.Data;

import java.util.Arrays;
import java.util.Scanner;

public class ImplementGenericS {
    public static void main(String[] args) {
        JV10<String> strObject=new JV10();
        strObject.setStore(new String[]{"","","","","","","","","",""});
//        strObject.add("Razak Mohamed S");strObject.add("Sridhar");
//        strObject.add("TietoEvry");
        //strObject.adding();
        System.out.println(Arrays.toString(strObject.getStore()));

        JV10<Double> dblObject=new JV10<>();
        dblObject.setStore(new Double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0});
        dblObject.adding();
        System.out.println(Arrays.toString(dblObject.getStore()));

    }
}

@Data
class JV10<T>{
    private T[] store;

    public void adding(){
        Scanner scanner=new Scanner(System.in);

        for(int index=0;index<store.length;index++){
            if(store[index] instanceof String){
                System.out.println("Enter the desired bank products ");
                store[index]= (T) scanner.next();
            }
            else if(store[index] instanceof Double){
                System.out.println("Enter the interest rates of loans ");
                store[index]= (T)(Double) scanner.nextDouble();
            }
        }
    }

    public void add(T data){
        for(int index=0;index<store.length;index++){
            if(store[index]==null){
                store[index]=data;
                return;
            }
        }
    }
}