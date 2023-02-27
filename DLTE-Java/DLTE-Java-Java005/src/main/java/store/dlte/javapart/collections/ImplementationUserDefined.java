package store.dlte.javapart.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImplementationUserDefined {
    public static void main(String[] args) {
        KYC kyc1=new KYC("Razak Mohamed S",9876545678945L,3400.6);
        KYC kyc2=new KYC("Arun",56789456545L,95400.6);
        KYC kyc3=new KYC("Sridhar M",45678765678L,87756.4);

        List<KYC> customers = Stream.of(kyc1,kyc2,kyc3).collect(Collectors.toList());

//        System.out.println(customers);

        Collections.sort(customers);

        customers.forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class KYC implements Comparable<KYC> {
    private String holder;
    private Long number;
    private Double balance;

    @Override
    public int compareTo(KYC o2) {
        //return o2.balance.compareTo(this.balance);
        //return this.holder.compareTo(o2.holder);
        return o2.holder.compareTo(this.holder);
    }
}
