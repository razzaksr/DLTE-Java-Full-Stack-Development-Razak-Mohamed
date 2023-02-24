package multithread;

public class ImplementationMethodReference {

    String[] schemes={"Health","Term","Car","Bike","Property"};

    public String collect(int position){
        return schemes[position];
    }

    public static void main(String[] args) {
        ImplementationMethodReference implement=new ImplementationMethodReference();
        System.out.println(implement.collect(0));

        // method reference
        // interface interfaceObject=currentObject::method
        Pointers pointers=implement::collect;

        // interfaceObject.interfaceMethod
        System.out.println(pointers.find(3));
    }
}

interface Pointers{
    String find(int index);
}
