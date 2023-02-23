package oop.dlte.javapart.remotes;

import java.util.Arrays;

public class ImplementingLambdas extends Request{
    public static void main(String[] args) {
//        Request req=new Request() {
//            @Override
//            public void loanSection() {
//                System.out.println("Only loan products are listed below\n"+Arrays.toString(this.getProducts()[1]));
//            }
//        };
//        req.viewProducts();
//        req.loanSection();
        ImplementingLambdas lambda=new ImplementingLambdas();
        lambda.viewProducts();
        lambda.loanSection();
    }

    @Override
    public void loanSection() {
        System.out.println("Only loan products are listed below\n"+Arrays.toString(this.getProducts()[1]));
    }
}
// abstract class : hybrid combination of both class and interface
abstract class Request{
    private String[][] products={{"Cheque book","Cards"},{"Agri","Car","Personal","Business"}};

    public String[][] getProducts() {
        return products;
    }

    public void setProducts(String[][] products) {
        this.products = products;
    }

    public void viewProducts(){
        for(String[] one:products){
            System.out.println(Arrays.toString(one));
        }
    }

    public abstract void loanSection();
}