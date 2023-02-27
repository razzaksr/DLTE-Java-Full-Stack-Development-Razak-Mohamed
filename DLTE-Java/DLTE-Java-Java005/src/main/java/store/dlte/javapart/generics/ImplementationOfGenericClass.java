package store.dlte.javapart.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class ImplementationOfGenericClass {
    public static void main(String[] args) {
        Warehouse<Integer> objectInt=new Warehouse<Integer>(new Integer[]{12,456,654,75,435});

        System.out.println(Arrays.toString(objectInt.getObjects()));

        Warehouse<Double> objectDouble=new Warehouse<Double>(new Double[]{8.5,90.54,12.4,11.4});

        System.out.println(Arrays.toString(objectDouble.getObjects()));
    }
}

//@Data
@AllArgsConstructor
@NoArgsConstructor
class Warehouse <T>{
    private  T[] objects;

    public T[] getObjects(){
        return objects;
    }
    public void setObjects(T[] objects){
        this.objects=objects;
    }
}