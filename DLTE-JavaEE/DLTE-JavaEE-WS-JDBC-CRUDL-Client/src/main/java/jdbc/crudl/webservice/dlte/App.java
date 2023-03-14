package jdbc.crudl.webservice.dlte;

import host.Kyc;
import host.KycCRUDLService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        host.KycCRUDLService service=new KycCRUDLService();
        host.KycCRUDL kycCRUDL=service.getKycCRUDLPort();

        host.ListOfKYC list= kycCRUDL.fetch();
        for(host.Kyc object:list.getKycs()){
            System.out.println(object.getAadhaar()+" "+object.getAccHolder()+" "+object.getAccNumber());
        }

        Scanner scanner=new Scanner(System.in);
        System.out.println("Entre the new kyc ");
        host.Kyc kyc=new Kyc();
        System.out.println("Enter the name of account holder ");
        kyc.setAccHolder(scanner.nextLine());
        System.out.println("Enter the Passcode ");
        kyc.setPasscode(scanner.nextLine());
        System.out.println("Enter the address ");
        kyc.setAddress(scanner.nextLine());
        System.out.println("Entre the email ");
        kyc.setEmail(scanner.nextLine());
        System.out.println("Enter the PAN ");
        kyc.setPan(scanner.nextLine());
        System.out.println("Enter the aadhaar ");
        kyc.setAadhaar(scanner.nextLong());
        System.out.println("Enter the balance ");
        kyc.setAccBal(scanner.nextDouble());
        System.out.println("Entre the contact ");
        kyc.setContact(scanner.nextLong());

        System.out.println(kycCRUDL.addKyc(kyc));
    }
}
