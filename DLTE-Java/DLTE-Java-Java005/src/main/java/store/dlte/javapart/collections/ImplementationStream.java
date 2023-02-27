package store.dlte.javapart.collections;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImplementationStream {
    public static void main(String[] args) {
        List collect=Stream.of(12,45,67,12,89,787,46).collect(Collectors.toList());

        System.out.println(collect);

        collect.stream().map(v-> v=(int)v-0.05).forEachOrdered(v->System.out.println(v));

    }
}
