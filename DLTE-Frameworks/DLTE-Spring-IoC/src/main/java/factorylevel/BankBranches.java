package factorylevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankBranches {
    private String bankName;
    private String branchName;
    private String ifsCode;
    private long contact;
}
