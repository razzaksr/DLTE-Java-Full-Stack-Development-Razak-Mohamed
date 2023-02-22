package oop.dlte.javapart;

public class Particular {

    static{
        System.out.println("Welcome to SavinCred Bank");
        System.out.println("KYC Particulars");
        Particular particular=new Particular();
        particular.stockMarket();
    }

    public static void main(String[] args) {}
    public void stockMarket(){
        System.out.println("Trades, Stocks, Funds managed here");
    }
}
