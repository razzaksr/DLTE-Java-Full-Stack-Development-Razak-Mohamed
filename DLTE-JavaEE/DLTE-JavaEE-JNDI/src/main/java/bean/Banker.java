package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banker {
    private int banker_id;
    private String banker_name;
    private String banker_passcode;
}
