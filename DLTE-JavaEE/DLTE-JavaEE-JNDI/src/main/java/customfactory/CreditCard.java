package customfactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    private String cardHolder;
    private int limit;
    private Collection<Integer> bills=new ArrayList<>();
}
