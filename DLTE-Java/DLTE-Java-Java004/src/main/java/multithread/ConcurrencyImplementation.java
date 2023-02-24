package multithread;

import java.util.Arrays;

// main class
public class ConcurrencyImplementation {
    public static void main(String[] args) {
        CoreOperations core=new CoreOperations();
//        core.addNewCustomer("Razak Mohamed S");
//        core.list();
        Thread t1=new Thread(core,"ICICI");
        Thread t2=new Thread(core,"AXIS");
        Thread t3=new Thread(core,"FEDERAL");
        Thread t4=new Thread(core,"Indian");

        t1.start();t2.start();t3.start();t4.start();
    }
}

interface Actions{
    void addNewCustomer(String name);
    int find(String name);
    int find(String name, int start, int end);
    void list();
}

// resource class
class CoreOperations implements Actions, Runnable{
    private String[] customers=new String[20];

    public CoreOperations(){
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
        return 0;
    }

    @Override
    public int find(String name, int start, int end) {
        return 0;
    }

    @Override
    public void list() {
        System.out.println(Arrays.toString(customers));
    }

    //execution point of the resource class
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId());
        list();
    }
}