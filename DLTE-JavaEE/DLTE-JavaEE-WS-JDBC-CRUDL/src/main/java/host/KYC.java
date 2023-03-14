package host;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KYC {
    private int acc_number;
    private String passcode, acc_holder, pan, email, address;

    private long contact, aadhaar;
    private double acc_bal;

}
