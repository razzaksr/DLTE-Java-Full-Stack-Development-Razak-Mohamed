package basic.dlte.javapart.group;

public class Blocks {
    public static void main(String[] args) {
        // Classname.staticMember
        Cards.findMax();
    }
}
class Cards{
    int[] outstanding={34900,12100,56000,23990,65700,120,560,1200,3200,1450,12410,23500};

    public static void findMax(){
        Cards card=new Cards();
        int firstMax=Integer.MIN_VALUE,secondMax=Integer.MIN_VALUE;
        for(int index=0;index<card.outstanding.length;index++){
            // 3000>> firstMax
            // firstMax = 34900, secondMax=12100 >> current 56000
            if(card.outstanding[index]>firstMax){
                secondMax=firstMax;
                firstMax=card.outstanding[index];
            }

            else if(card.outstanding[index]>secondMax){
                secondMax=card.outstanding[index];
            }
        }
        System.out.println("Maximum outstanding are "+firstMax+" and "+secondMax);
    }
}