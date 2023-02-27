package store.dlte.javapart.storage;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImplementingCollectionTogetherWithFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\NithiBank.doc");

//        Wallet paytm=new Wallet("rajesh@gmail.com",112233, 98766789345L,2500.8);
//        Wallet phonepay=new Wallet("divikar@gmail.com",998877, 67876567456L,1200.56);
//        Wallet bharatpay=new Wallet("narendra.up@gmail.com",456789, 23454334556L,91200.5);
//
//        FileOutputStream fos=new FileOutputStream(file);
//        ObjectOutputStream oos=new ObjectOutputStream(fos);
//
//        List<Wallet> list= Stream.of(paytm,phonepay,bharatpay).collect(Collectors.toList());
//
//        oos.writeObject(list);
//
//        oos.close();
//        fos.close();

        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois=new ObjectInputStream(fis);

        List<Wallet> received=(List<Wallet>) ois.readObject();

        ois.close();
        fis.close();

        received.forEach(System.out::println);
    }
}
