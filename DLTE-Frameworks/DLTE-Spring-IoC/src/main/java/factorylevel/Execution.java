package factorylevel;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Execution {
    public static void main(String[] args) {
        BeanFactory beanFactory=new XmlBeanFactory(new FileSystemResource("spring-config.xml"));
        BankBranches bankBranches=beanFactory.getBean("bank1", BankBranches.class);
        System.out.println(bankBranches);

        BankBranches bankBranches1=beanFactory.getBean("bank2",BankBranches.class);
        System.out.println(bankBranches1);

        BankBranches bankBranches2=beanFactory.getBean("bank3", BankBranches.class);
        System.out.println(bankBranches2);
    }
}
