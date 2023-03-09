package customfactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements Serializable {
    private String cardHolder;
    private int limit;
    private Collection<Integer> bills=new ArrayList<>();
    public CreditCard(String cardHolder, int limit) {
        this.cardHolder = cardHolder;
        this.limit = limit;
    }
}
