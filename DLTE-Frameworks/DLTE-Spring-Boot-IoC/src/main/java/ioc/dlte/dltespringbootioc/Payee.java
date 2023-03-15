package ioc.dlte.dltespringbootioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payee {
    private String payeeName;
    private long payeeAccountNumber;
    private String payeeUpiId;
    private long payeeContact;
}
