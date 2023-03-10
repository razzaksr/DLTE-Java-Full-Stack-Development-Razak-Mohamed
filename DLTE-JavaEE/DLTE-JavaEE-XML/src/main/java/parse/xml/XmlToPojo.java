package parse.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlToPojo {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context=JAXBContext.newInstance(Banker.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        Banker branchOfficer = (Banker)  unmarshaller.unmarshal(new File("manager-details.xml"));
        System.out.println(branchOfficer);
    }
}
