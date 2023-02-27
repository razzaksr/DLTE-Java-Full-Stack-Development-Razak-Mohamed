package store.dlte.javapart.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImplementationReadRegular {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\DLTE-Java Full Stack Development - Razak Mohamed\\DLTE-Front End\\DLTE-FE-BankUC-ClientSide\\files\\customer.js");
        //File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\Gamer.txt");
        FileInputStream fis=new FileInputStream(file);

        byte[] buffer=new byte[fis.available()];
        fis.read(buffer);

        fis.close();

        System.out.println(file.getName()+"Has following contents\n"+new String(buffer));
    }
}
