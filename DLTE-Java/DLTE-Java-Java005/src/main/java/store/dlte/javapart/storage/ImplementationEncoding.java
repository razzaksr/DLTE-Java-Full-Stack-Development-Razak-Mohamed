package store.dlte.javapart.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.DeflaterOutputStream;

public class ImplementationEncoding {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\MITEBankOfManglore.doc");
        FileOutputStream fos=new FileOutputStream(file);
        DeflaterOutputStream dos=new DeflaterOutputStream(fos);

        Wallet paytm=new Wallet("rajesh@gmail.com",112233, 98766789345L,2500.8);
        Wallet phonepay=new Wallet("divikar@gmail.com",998877, 67876567456L,1200.56);
        Wallet bharatpay=new Wallet("narendra.up@gmail.com",456789, 23454334556L,91200.5);

        dos.write(paytm.toString().getBytes());
        dos.write(phonepay.toString().getBytes());
        dos.write(bharatpay.toString().getBytes());

        dos.close();
        fos.close();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Wallet implements Serializable {
    private String username;
    private int upi;
    private long accNum;
    private double available;
}