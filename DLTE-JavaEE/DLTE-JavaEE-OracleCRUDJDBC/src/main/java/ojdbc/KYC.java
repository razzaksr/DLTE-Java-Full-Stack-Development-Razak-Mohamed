package ojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KYC {
    private int acc_number;
    private String passcode, email, acc_holder, pan, address;
    private long aadhaar,contact;
    private double acc_bal;
}
