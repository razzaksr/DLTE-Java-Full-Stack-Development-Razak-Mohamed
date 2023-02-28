package concurrency.console.dlte.javapart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class ImplementingExecutors {
    public static void main(String[] args) {
        Wallet wall=new Wallet();
//        Thread thread1=new Thread(wall,"Pooja");
//        Thread thread2=new Thread(wall,"Surya");
//        Thread thread3=new Thread(wall,"Amrutha");
//        thread1.start();thread2.start();thread3.start();

        Executor executor= Executors.newCachedThreadPool();
        executor.execute(wall);

        ThreadPoolExecutor pool= (ThreadPoolExecutor) executor;
        pool.shutdown();

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Gpay{
    private String username;
    private int upi;
    private double accountBalance;
}
// resource class
class Wallet implements Runnable{

    Lock lock=new ReentrantLock();

    ArrayList<Gpay> customers=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);

    public Wallet(){
        customers.add(new Gpay("razzaksr",1122,560.9));
        customers.add(new Gpay("sridharm",9988,12546.8));
        customers.add(new Gpay("arun",7892,8922.5));
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("Welcome admin "+Thread.currentThread().getName());
        System.out.println("Enter the process to proceed by "+Thread.currentThread().getName());
        String process= scanner.next();
        switch (process){
            case "view":listAll();break;
            case "update":
                System.out.println("Enter the username to update ");
                updateCustomer(scanner.next());
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        lock.unlock();
//        synchronized (scanner){
//            System.out.println("Enter the process to proceed by "+Thread.currentThread().getName());
//            String process= scanner.next();
//            switch (process){
//                case "view":listAll();break;
//                case "update":
//                    System.out.println("Enter the username to update ");
//                    updateCustomer(scanner.next());
//                    break;
//            }
//        }
    }

    private void updateCustomer(String username){
        for(int index=0;index< customers.size();index++){
            if(customers.get(index).getUsername().equalsIgnoreCase(username)){
                Gpay current=customers.get(index);
                System.out.println("Tell us what to update either UPI/ Balance");
                String option=scanner.next();
                switch(option){
                    case "pin":
                        System.out.println("Enter the old pin ");
                        int verify= scanner.nextInt();
                        if(current.getUpi()==verify){
                            System.out.println("Set the new pin ");
                            current.setUpi(scanner.nextInt());
                            customers.set(index,current);
                            System.out.println(customers.get(index));
                            return;
                        }
                        else{
                            System.out.println("Wrong pin");
                            return;
                        }
                        //break;
                    //default:System.out.println("Nothing you can update through "+Thread.currentThread().getName());
                }
            }
        }
        System.out.println("Updation failed");
    }

    private void listAll(){
        customers.forEach(System.out::println);
    }
}