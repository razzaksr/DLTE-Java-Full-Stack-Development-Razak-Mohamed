package soap.dlte.web.dltespringsoapwebservice.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bank_officials")
public class OfficialsPojo implements Serializable {
    @Id
    private int userId;
    private String fullName, branchCode, passCode;
    private long contact;
}
