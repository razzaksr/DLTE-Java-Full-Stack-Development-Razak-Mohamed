package store.dlte.javapart.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class ImplementationSets {
    public static void main(String[] args) {
        HashSet<String> stocks=new HashSet<>();
        stocks.add("Equity");stocks.add("Mutual");stocks.add("Debt");
        stocks.add("Liquidity");
        System.out.println(stocks);
        TreeSet<String> services=new TreeSet<>();
        services.addAll(stocks);
        System.out.println(services);

        services.remove("Mutual");

        System.out.println(stocks.contains("Mutual"));
    }
}
