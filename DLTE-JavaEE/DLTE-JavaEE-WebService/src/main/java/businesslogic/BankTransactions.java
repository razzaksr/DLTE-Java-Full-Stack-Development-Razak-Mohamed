package businesslogic;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BankTransactions {
    private int[] statements={1200,5600,410,120,670,409,120,46,87,346,995,95,545};

    @WebMethod
    public int read(int index){
        if(index<statements.length&&index>=0){
            return statements[index];
        }
        else{
            return -1;
        }
    }

    @WebMethod
    public int search(int value){
        for(int index=0;index< statements.length;index++){
            if(value==statements[index])
                return index;
        }
        return -1;
    }
}
