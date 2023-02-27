package store.dlte.javapart.storage;

import java.io.*;

public class ImplementingSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\PeopleBank.doc");

//        Wallet paytm=new Wallet("rajesh@gmail.com",112233, 98766789345L,2500.8);
//        Wallet phonepay=new Wallet("divikar@gmail.com",998877, 67876567456L,1200.56);
//        Wallet bharatpay=new Wallet("narendra.up@gmail.com",456789, 23454334556L,91200.5);
//
//        FileOutputStream fos=new FileOutputStream(file);
//        ObjectOutputStream oos=new ObjectOutputStream(fos);
//
//        oos.writeObject(paytm);oos.writeObject(phonepay);oos.writeObject(bharatpay);
//
//        oos.close();
//        fos.close();

        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);

        Wallet wall=(Wallet)ois.readObject();
        System.out.println(wall);
        wall=(Wallet)ois.readObject();
        System.out.println(wall);
        wall=(Wallet)ois.readObject();
        System.out.println(wall);

        ois.close();
        fis.close();
    }
}
