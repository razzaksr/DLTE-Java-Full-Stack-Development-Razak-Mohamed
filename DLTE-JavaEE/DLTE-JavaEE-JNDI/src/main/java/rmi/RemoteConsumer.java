package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class RemoteConsumer {
    public static void main(String[] args) throws NamingException {
        Hashtable hashtable=new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        hashtable.put(Context.PROVIDER_URL,"rmi://localhost:1010");
        Context context=new InitialContext(hashtable);
        RemoteProvider provider = (RemoteProvider) context.lookup("dlte/details");
        provider.search(6000);
    }
}
