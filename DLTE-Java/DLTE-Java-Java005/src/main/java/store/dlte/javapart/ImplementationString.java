package store.dlte.javapart;

import java.util.Arrays;

public class ImplementationString {
    public static void main(String[] args) {
        // literal
        String bankName="SavinCred";
        // non literal
        String ifscCode=new String("ABCD888801   ");
        byte[] alpha={65,89,98,99,43,72};
        System.out.println(Arrays.toString(alpha));
        String converted=new String(alpha);
        System.out.println(converted);
        alpha=ifscCode.getBytes();
        System.out.println(Arrays.toString(alpha));

        System.out.println(bankName.compareToIgnoreCase("savincred"));

        System.out.println(ifscCode.length());

        ifscCode=ifscCode.trim();

        System.out.println(ifscCode.length());

        String newBankName=bankName.substring(2,7);
        System.out.println(newBankName);

        System.out.println(ifscCode.charAt(0));

        bankName=bankName.replace("Cred","Debit");
        System.out.println(bankName);
    }
}
