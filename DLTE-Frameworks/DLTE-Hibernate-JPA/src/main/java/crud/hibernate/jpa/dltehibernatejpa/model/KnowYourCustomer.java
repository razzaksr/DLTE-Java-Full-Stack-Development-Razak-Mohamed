package crud.hibernate.jpa.dltehibernatejpa.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class KnowYourCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountNumber;
    @NonNull
    private String accountHolder;
    @NonNull
    private String email;
    @NonNull
    private String pan;
    private long contact;
    private long aadhaar;
    @NonNull
    private String address;
    private double accountBalance;
    @NonNull
    private String accountPasscode;
}
