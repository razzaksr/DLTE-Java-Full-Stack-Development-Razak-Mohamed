package rmi;

import customfactory.CreditCard;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoteProvider implements CardRemote, Serializable {
    private int[] holders={1200,5600,6700,300,5600,1200,600,4500,2300,530};
    Registry registry;
    static Context context;

    public RemoteProvider(){
        try {
            registry = LocateRegistry.createRegistry(1010);
            Hashtable hashtable=new Hashtable();
            hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            hashtable.put(Context.PROVIDER_URL,"rmi://localhost:1010");
            context=new InitialContext(hashtable);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void search(int limit) {
        for(int index=0;index<holders.length;index++){
            if(holders[index]>=limit)
                System.out.println(holders[index]);
        }
    }

    public static void main(String[] args) throws IOException, NamingException {

        RemoteProvider provider=new RemoteProvider();

        context.bind("dlte/details",provider);
        System.in.read();
        //Thread.sleep(30000);

    }
}
