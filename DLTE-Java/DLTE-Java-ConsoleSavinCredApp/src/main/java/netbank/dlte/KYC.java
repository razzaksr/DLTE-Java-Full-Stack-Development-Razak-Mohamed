package netbank.dlte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KYC implements Serializable {
    private String username, password, address, email;
    private Long contact;
    private Double balance;
    private Date dateOfOpened;
    private ArrayList<String> transactions=new ArrayList<>();

    public KYC(String username, String password, String address, String email, Long contact, Double balance) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.balance = balance;
    }
}
