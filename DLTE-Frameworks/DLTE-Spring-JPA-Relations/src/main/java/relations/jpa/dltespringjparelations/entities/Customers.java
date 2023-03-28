package relations.jpa.dltespringjparelations.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Customers {
    @Id
    private long accountNumber;
    private String accountHolder;
    private long contact;
    private double accountBalance;
    private String accountPasscode;
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "BeneficiaryMapper",joinColumns = @JoinColumn(name = "Customer"),inverseJoinColumns = @JoinColumn(name = "Payee"))
    @Nullable
    @JsonBackReference
    private List<Payees> myBeneficiary=new ArrayList<>();
}
