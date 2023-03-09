package branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean
@RequestScoped
public class Loans {
    private String entityName;
    private Collection<String> available=new ArrayList<>();
    private String selected;

    @PostConstruct
    public void loads(){
        available.add("Business Loan");
        available.add("House Loan");
        available.add("Education Loan");
        available.add("Gold Loan");
    }
}
