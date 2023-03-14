package ioc.spring.dlte;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        SavinCred savinCred=new SavinCred();
//        System.out.println(savinCred.getBranches());
//        savinCred.deleteBranch("kathriguppe");
//        System.out.println(savinCred.findContact("kathriguppe"));

        ApplicationContext context=new ClassPathXmlApplicationContext("dlte-spring.xml");
        SavinCred savin=context.getBean("savinCred", SavinCred.class);
        System.out.println(savin.toString());
        System.out.println(savin.findContact("banglore"));
        savin.deleteBranch("banglore");

    }
}
