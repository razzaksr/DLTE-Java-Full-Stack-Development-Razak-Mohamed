package oop.dlte.javapart.remotes;

public class ImplementLambdaNonStatic {
    public void access(){
        Operate operate=((start, end) -> {
            for(int index=start;index<end;index++){
                System.out.println(todayRequests[index]);
            }
        } );

        operate.filter(1,6);
    }
    String[] todayRequests={"Razak","Sabari","Mohamed","Sridhar","Mani","Manvith","Surya"};
    public static void main(String[] args) {
        ImplementLambdaNonStatic lambda=new ImplementLambdaNonStatic();
        lambda.access();
    }
}