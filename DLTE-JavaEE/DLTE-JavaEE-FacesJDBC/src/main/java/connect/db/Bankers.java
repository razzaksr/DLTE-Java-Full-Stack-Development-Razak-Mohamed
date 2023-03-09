package connect.db;

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
public class Bankers {

    private String banker_passcode;
    private String banker_name;
    private int banker_id;

}
