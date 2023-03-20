package datasource.library.dlte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int transactionId;
    private long transactionFrom;
    private long transactionTo;
    private double amount;
    private Date happened;
}
