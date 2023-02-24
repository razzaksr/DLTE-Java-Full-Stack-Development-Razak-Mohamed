package multithread;

/*
Implementing Thread and Method reference for access different methods by threads
 */

import java.util.Arrays;
import java.util.Scanner;

public class ImplementThreadWithMethodReference {
    public static void main(String[] args) throws InterruptedException {
        MajorOperations major=new MajorOperations();

        Thread t1=new Thread(major::list,"AXIS");
        Thread t2=new Thread(major::addNewCustomer,"ICICI");
        Thread t3=new Thread(major::addNewCustomer,"Canara");
        Thread t4=new Thread(major::addNewCustomer,"Federal");
        Thread t5=new Thread(major::list,"Union");

        t1.start();
        t2.start();t2.join();
        t3.start();t3.join();
        t4.start();t4.join();
        t5.start();

    }
}

class MajorOperations{
    private String[] customers=new String[20];
    static Scanner scanner=new Scanner(System.in);

    public MajorOperations(){
        customers[0]="Razak Mohamed S";customers[1]="Sridhar";
        customers[2]="Surya";customers[3]="Aishwaya";
    }

    public void addNewCustomer() {
        System.out.println(Thread.currentThread().getName()+" Enter the name wish to add as a customer ");
        String name= scanner.next();
        for(int index=0;index<customers.length;index++){
            if(customers[index]==null){
                customers[index]=name;
                System.out.println(name+" is our new customer");
                return;
            }
        }
        System.out.println(name+" can't be added as new customer");
    }


    public int find() {
        System.out.println(Thread.currentThread().getName()+"Enter the name wish to search");
        String name=scanner.next();
        for(int index=0;index<customers.length;index++){
            if(customers[index].equalsIgnoreCase(name))
                return index;
        }
        return -1;
    }

    public void list() {
        System.out.println(Thread.currentThread().getName()+"\n"+
                Arrays.toString(customers));
    }
}