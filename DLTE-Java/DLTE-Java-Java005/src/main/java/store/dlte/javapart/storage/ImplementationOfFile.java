package store.dlte.javapart.storage;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImplementationOfFile {
    public static void main(String[] args) throws IOException {
//        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\Gourav.doc");
//        file.createNewFile();
//        System.out.println(file.getName()+" has created");

        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\Gamer.txt");
        FileOutputStream fos=new FileOutputStream(file);
        DataInputStream dis=new DataInputStream(System.in);

        System.out.println("Enter the bank's highlights");
        String content=dis.readLine();

        fos.write(content.getBytes());

        fos.close();

        System.out.println(file.getName()+" has bank information");
    }
}
