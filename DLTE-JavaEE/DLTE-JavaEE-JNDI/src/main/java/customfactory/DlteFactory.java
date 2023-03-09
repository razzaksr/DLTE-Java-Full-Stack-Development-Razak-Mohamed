package customfactory;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DlteFactory implements ObjectFactory {

    /*
    <Reference
    cardHolder="Razak Mohamed S"
    limit="55000"
    bills="1200,7800,555"
    />

     */

    @Override
    public Object getObjectInstance(Object obj, Name nameCard, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        CreditCard creditCard=new CreditCard();
        Reference reference=(Reference)obj;
        Enumeration enumeration=reference.getAll();
        while(enumeration.hasMoreElements()){
            RefAddr refAddr = (RefAddr)enumeration.nextElement();
            String name=refAddr.getType();
            String value= (String) refAddr.getContent();
            if(name.equalsIgnoreCase("cardHolder")){
                creditCard.setCardHolder(value);
            }
            else if (name.equalsIgnoreCase("bills")) {
                String[] arr=value.split(",");
                for(int index=0;index< arr.length;index++){
                    creditCard.getBills().add(Integer.parseInt(arr[index]));
                }
            }
            else if (name.equalsIgnoreCase("limit")) {
                creditCard.setLimit(Integer.parseInt(value));
            }
        }
        return creditCard;
    }
}
