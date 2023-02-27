package store.dlte.javapart.collections;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

/*
put(k,v)
putAll>> copy

get(k)

remove(k)

keySet>> Set
values()>> Collection

containsKey
containsValue

 */

public class ImplementationMaps {
    public static void main(String[] args) {

        KYC kyc1=new KYC("Razak Mohamed S",9876545678945L,3400.6);
        KYC kyc2=new KYC("Arun",56789456545L,95400.6);
        KYC kyc3=new KYC("Sridhar M",45678765678L,87756.4);
        KYC kyc4=new KYC("Sabarinathan S",1234532345565L,3100.6);
        KYC kyc5=new KYC("Rajiya R",7656787678784L,6400.6);
        KYC kyc6=new KYC("Srikanth",5678904567L,91756.4);

        Hashtable<String,KYC> accounts=new Hashtable<>();
        accounts.put("ABSCD876A",kyc1);
        accounts.put("ABSCD876A",kyc5);
        accounts.put("BVCFV67890A",kyc2);
        accounts.put("ASDF234F",kyc3);
        accounts.put("ODCCD2345",kyc4);
        accounts.put("87678934A",kyc6);

        System.out.println(accounts);

        accounts.remove("ABSCD876A");

        System.out.println(accounts.containsKey("ABSCD876A"));

        System.out.println(accounts.containsValue(kyc2));

        Set<String> PAN=accounts.keySet();
        PAN.forEach(System.out::println);

        Collection<KYC> holders=accounts.values();
        holders.forEach(v->System.out.println(v));

    }
}
