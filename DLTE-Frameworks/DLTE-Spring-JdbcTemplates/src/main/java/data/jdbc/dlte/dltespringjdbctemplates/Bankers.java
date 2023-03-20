package data.jdbc.dlte.dltespringjdbctemplates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bankers {
    private int bankerId;
    private String bankerName;
    private String bankerPasscode;
}
