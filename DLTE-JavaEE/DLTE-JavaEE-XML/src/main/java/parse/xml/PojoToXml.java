package parse.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PojoToXml {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context=JAXBContext.newInstance(Banker.class);

        Marshaller marshaller=context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        Banker banker=new Banker(1290001,"razzaksr",987656783,"mohamed@123","razzaksr@gmail.com");
        marshaller.marshal(banker,new FileOutputStream("banker-details.xml"));

        System.out.println("XML has created");
    }
}
