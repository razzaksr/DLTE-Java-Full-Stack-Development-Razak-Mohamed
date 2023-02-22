package oop.dlte.javapart.opp.inner;

public class ImplementingLocalClass {
    public static void main(String[] args) {
        Deposits deposits=new Deposits();
        deposits.openDeposits();
    }
}

// Inner Class as local member
class Deposits{
    public void openDeposits(){
        //int loanNumber=123;
        class FixedDeposit{
            private String holderName;
            private String nominee;
            private int principle;
            private int tenure;

            public String getHolderName() {
                return holderName;
            }

            public void setHolderName(String holderName) {
                this.holderName = holderName;
            }

            public String getNominee() {
                return nominee;
            }

            public void setNominee(String nominee) {
                this.nominee = nominee;
            }

            public int getPrinciple() {
                return principle;
            }

            public void setPrinciple(int principle) {
                this.principle = principle;
            }

            public int getTenure() {
                return tenure;
            }

            public void setTenure(int tenure) {
                this.tenure = tenure;
            }

            // constructor overloading

            // default constructor
            public FixedDeposit(){}
            // parameterized constructor
            public FixedDeposit(String holderName,String nominee,int principle,int tenure){
                this.holderName=holderName;
                this.nominee=nominee;
                this.principle=principle;
                this.tenure=tenure;
            }
        }
        FixedDeposit fixed=new FixedDeposit();
        fixed.setHolderName("Razak Mohamed S");
        fixed.setNominee("Rasheedha");
        fixed.setTenure(5);
        fixed.setPrinciple(500000);

        System.out.println(fixed.getHolderName()+" "+fixed.getPrinciple());

        FixedDeposit fdeposit=new FixedDeposit("Arun","Sridhar",100000,5);

        System.out.println(fdeposit.getNominee()+" "+fdeposit.getPrinciple()+" "+fdeposit.getHolderName());
    }
}