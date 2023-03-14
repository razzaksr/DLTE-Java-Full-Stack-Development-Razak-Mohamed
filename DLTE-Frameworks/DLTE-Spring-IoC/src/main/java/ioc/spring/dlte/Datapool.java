package ioc.spring.dlte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.TreeMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Datapool {
    private Map<String,Long> branches=new TreeMap<>();

    public abstract long findContact(String branchName);
    public abstract void deleteBranch(String branchName);
}
