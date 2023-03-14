package host;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfKYC {
    private ArrayList<KYC> kycs=new ArrayList<>();
}
