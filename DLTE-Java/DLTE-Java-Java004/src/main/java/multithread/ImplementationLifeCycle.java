package multithread;

import java.util.Arrays;
import java.util.Scanner;

public class ImplementationLifeCycle {
    public static void main(String[] args) {
        SavinFinance savinFinance=new SavinFinance();

        Thread thread1=new Thread(savinFinance,"ICICI");
        Thread thread2=new Thread(savinFinance,"AXIS");
        Thread thread3=new Thread(savinFinance,"Canara");
        thread1.start();thread2.start();thread3.start();

        MajorOperations major=new MajorOperations();
        Thread thread4=new Thread(major::list,"Canara");
        thread4.start();
    }
}
class SavinFinance implements Actions, Runnable{

    private String[] customers=new String[20];
    static Scanner scanner=new Scanner(System.in);

    public SavinFinance(){
        customers[0]="Razak Mohamed S";customers[1]="Sridhar";
        customers[2]="Surya";customers[3]="Aishwaya";
    }

    @Override
    public void addNewCustomer(String name) {
        for(int index=0;index<customers.length;index++){
            if(customers[index]==null){
                customers[index]=name;
                System.out.println(name+" is our new customer");
                return;
            }
        }
        System.out.println(name+" can't be added as new customer");
    }

    @Override
    public int find(String name) {
        for(int index=0;index<customers.length;index++){
            if(customers[index]==null){
                System.out.println(Thread.currentThread().getName()+" will not get anything and process aborted");
                Thread.currentThread().stop();
            }
            if(customers[index].equalsIgnoreCase(name))
                return index;
        }
        return -1;
    }

    @Override
    public int find(String name, int start, int end) {
        for(int index=start;index<end;index++){
            if(customers[index]==null){
                System.out.println(Thread.currentThread().getName()+" will not get anything and process aborted");
                Thread.currentThread().stop();
            }
            if(customers[index].equalsIgnoreCase(name))
                return index;
        }
        return -1;
    }

    @Override
    public void list() {
        System.out.println(Arrays.toString(customers));
    }

    @Override
    public synchronized void run() {
        System.out.println("Welcome "+Thread.currentThread().getName());
        System.out.println("Which operation to perform ");
        String option= scanner.next();
        switch(option){
            case "add":
                System.out.println("Enter the new customer name ");
                addNewCustomer(scanner.next());
                break;
            case "view":list();break;
            case "find":
                System.out.println("Enter the name to find ");
                String name= scanner.next();
                System.out.println("Are you wish to search between ranges");
                String consent=scanner.next();
                if(consent.equalsIgnoreCase("yes")){
                    System.out.println("Enter the start and end range ");
                    System.out.println(find(name, scanner.nextInt(), scanner.nextInt()));
                }
                else{
                    System.out.println(find(name));
                }
                break;
            default:System.out.println("Invalid option");
        }
    }
}
