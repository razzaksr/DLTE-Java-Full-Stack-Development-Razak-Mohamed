package store.dlte.javapart;

import java.util.Scanner;

public class ImplementDenomination {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int _2000s=10, _500s=10, _200s=20, _100s=50;
        int userDesired=0, sum=0, required=0;
        String receipt="";

        System.out.println("Tell us desired amount to debit ");
        userDesired= scanner.nextInt();// 12000

        sum=(_2000s*2000)+(_500s*500)+(_200s*200)+(_100s*100);

        if(userDesired<=sum){
            if(_2000s>0){
                required=userDesired/2000;// 6
                if(required<=_2000s){
                    _2000s-=required;
                    receipt+="2000 X "+required+"\n";
                    userDesired-=required*2000;
                }
                else{
                    userDesired-=_2000s*2000;
                    receipt+="2000 X "+_2000s+"\n";
                    _2000s=0;
                }
            }
            if(_500s>0&&userDesired>0){
                required=userDesired/500;// 6
                if(required<=_500s){
                    _500s-=required;
                    receipt+="500 X "+required+"\n";
                    userDesired-=required*500;
                }
                else{
                    userDesired-=_500s*500;
                    receipt+="500 X "+_500s+"\n";
                    _500s=0;
                }
            }
            if(_200s>0&&userDesired>0){
                required=userDesired/200;// 6
                if(required<=_200s){
                    _200s-=required;
                    receipt+="200 X "+required+"\n";
                    userDesired-=required*200;
                }
                else{
                    userDesired-=_200s*200;
                    receipt+="200 X "+_200s+"\n";
                    _200s=0;
                }
            }
            if(_100s>0&&userDesired>0){
                required=userDesired/100;// 6
                if(required<=_100s){
                    _100s-=required;
                    receipt+="100 X "+required+"\n";
                    userDesired-=required*100;
                }
                else{
                    userDesired-=_100s*100;
                    receipt+="100 X "+_100s+"\n";
                    _100s=0;
                }
            }

            if(userDesired==0){
                System.out.println("Amount required by customer has been dispensed");
                System.out.println(receipt);
            }
            else{
                System.out.println("Insufficient");
            }
        }
        else{
            System.out.println("Insufficient amount in machine");
        }


        scanner.close();
    }
}
