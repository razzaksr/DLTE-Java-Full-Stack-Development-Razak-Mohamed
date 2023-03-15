package ioc.dlte.dltespringbootioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ioc.dlte.dltespringbootioc")
public class PayeeConfiguration {
    @Bean
    public Payee getPayee(){
        Payee payee=new Payee();
        return payee;
    }
}