package testing.unit.dlte;

import java.util.Hashtable;

public class Moderator {
    private Hashtable<String,Integer> bonds=new Hashtable<String, Integer>();

    public Moderator(){
        bonds.put("FD",12900);bonds.put("Bharath",983454);
        bonds.put("State",8745);bonds.put("Gold",81284);
    }

    public Integer findBondValue(String bondName){
        if(bonds.containsKey(bondName))
            return bonds.get(bondName);
        else
            return 0;
    }
}
