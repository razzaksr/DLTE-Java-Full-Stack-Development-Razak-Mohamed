package oop.dlte.javapart.opp.inner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class ImplementingAnonymousInner {
    public static void main(String[] args) {
//        Insurance insuranceOne=new Insurance();
//        insuranceOne.setAddons(new String[]{"Cancer Pro","Complete Bed charges","Claim immediate"});
//        insuranceOne.setInsurer("Razak Mohamed S");
//        insuranceOne.setScheme("Health Insurance TATA - AIA");
//        insuranceOne.setTerm(1);

        Insurance insuranceOne=new Insurance("Razak Mohamed S","Health Insurance",50000,2,new String[]{"Cancer Pro","Complete Bed charges","Claim immediate"});

        //System.out.println(insuranceOne.getInsurer()+" "+insuranceOne.getScheme());

        System.out.println(insuranceOne);
//        String info=insuranceOne.toString();
//        System.out.println(info);

        System.out.println(new Insurance("Arun","Term Insurance",5000000,10,new String[]{"Accendantel","Natural"}).getAmount());

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Insurance{
    private String insurer;
    private String scheme;
    private int amount;
    private int term;
    private String[] addons;

//    public String toString(){
//        return "Insurance details "+insurer+" "+scheme+" "+ Arrays.toString(addons)+" "+amount+" "+term;
//    }
//
//    public Insurance() {
//    }
//
//    public Insurance(String insurer, String scheme, int amount, int term, String[] addons) {
//        this.insurer = insurer;
//        this.scheme = scheme;
//        this.amount = amount;
//        this.term = term;
//        this.addons = addons;
//    }
//
//    public String getInsurer() {
//        return insurer;
//    }
//
//    public void setInsurer(String insurer) {
//        this.insurer = insurer;
//    }
//
//    public String getScheme() {
//        return scheme;
//    }
//
//    public void setScheme(String scheme) {
//        this.scheme = scheme;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public int getTerm() {
//        return term;
//    }
//
//    public void setTerm(int term) {
//        this.term = term;
//    }
//
//    public String[] getAddons() {
//        return addons;
//    }
//
//    public void setAddons(String[] addons) {
//        this.addons = addons;
//    }
}