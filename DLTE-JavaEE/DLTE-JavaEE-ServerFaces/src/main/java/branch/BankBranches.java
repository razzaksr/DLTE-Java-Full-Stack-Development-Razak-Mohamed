package branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

// BankBranch Bean
@Data
@NoArgsConstructor
@AllArgsConstructor

@ManagedBean
@RequestScoped
public class BankBranches {
    private String bankName;
    private String branchName;
    private String ifsCode;
    private long contact;
}
