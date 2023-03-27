package relations.jpa.dltespringjparelations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payees {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int beneficiaryId;
    private String beneficiaryName;
    private long accountNumber;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "Customer_ID")
    private Customers customer;
}
