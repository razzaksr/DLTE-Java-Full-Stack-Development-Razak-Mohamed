package ioc.dlte.dltespringbootioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class DlteSpringBootIoCApplication {

    public static void main(String[] args) {
        SpringApplication.run(DlteSpringBootIoCApplication.class, args);
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(PayeeConfiguration.class);
        Payee payeeOne=applicationContext.getBean(Payee.class);
        payeeOne.setPayeeName("Arun");payeeOne.setPayeeContact(876546789456L);payeeOne.setPayeeAccountNumber(765456789876L);
        payeeOne.setPayeeUpiId("arundlithe@okaxis");
        System.out.println(payeeOne);
    }

}
