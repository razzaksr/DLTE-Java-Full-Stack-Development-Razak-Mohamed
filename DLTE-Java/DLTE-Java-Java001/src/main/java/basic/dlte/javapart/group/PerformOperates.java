package basic.dlte.javapart.group;

public class PerformOperates {
    public static void main(String[] args) {
        LoanCustomers loan=new LoanCustomers();
        loan.reverse();

        PerformOperates perform=new PerformOperates();
        perform.match("S");
    }

    public void match(String phrase){
        LoanCustomers customers=new LoanCustomers();
        for(int index=0;index<customers.borrowers.length;index++){
            if(customers.borrowers[index].contains(phrase)){
                System.out.println("Matched "+customers.borrowers[index]);
            }
        }
    }

}

class LoanCustomers{

    String[] borrowers={"Sabari","Srinivas","Victor","Prem","Arun","Razak","Manvith","Suresh",
    "Surya","Bala","Vikrant","Madhan"};

    // 10; 0-9

    public void reverse(){
        for(int index=borrowers.length-1;index>=0;index--){
            System.out.println(borrowers[index]);
        }
    }

}