package store.dlte.javapart.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ImplementationLinkedList {
    public static void main(String[] args) {
        //List listOne=new LinkedList();
        LinkedList listOne=new LinkedList();
        LinkedList<Long> listTwo=new LinkedList<>();

        listOne.add("Razak Mohamed");listOne.addFirst(987656789L);
        listOne.add('S');listOne.add(1,true);

        System.out.println(listOne);

        listTwo.add(8765678976789L);listTwo.add(456788765678L);
        listTwo.add(45678765678L);listTwo.add(56789876545678L);

        Iterator<Long> it= listTwo.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        listTwo.set(1,11111111111111L);

        System.out.println(listTwo.get(1));

        listTwo.remove();// removeFirst

        System.out.println("Listing account numbers");
        listTwo.forEach(System.out::println);// method reference

        listOne.remove(1);
        System.out.println(listOne);
        listTwo.removeLast();
        System.out.println(listTwo);
        listOne.remove("Razak Mohamed");

        System.out.println(listOne);

        System.out.println(listOne.indexOf(true));

        System.out.println(listTwo.indexOf(45678765678L));

    }
}
