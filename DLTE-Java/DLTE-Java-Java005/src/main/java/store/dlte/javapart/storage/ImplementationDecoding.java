package store.dlte.javapart.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class ImplementationDecoding {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\Course backups\\Java\\DLithe2023Feb-Corporate-TietoEvry\\MITEBankOfManglore.doc");
        FileInputStream fis=new FileInputStream(file);
        InflaterInputStream iis=new InflaterInputStream(fis);

        byte[] buffer=new byte[fis.available()];

        iis.read(buffer);

        iis.close();
        fis.close();

        System.out.println(new String(buffer));
    }
}
