package branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ManagedBean
@RequestScoped
public class BranchFeatures {
    private String bankName;
    private long contact;
    private String feature;
}
