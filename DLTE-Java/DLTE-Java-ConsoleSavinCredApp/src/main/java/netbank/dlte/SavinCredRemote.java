package netbank.dlte;

import java.util.Date;

public interface SavinCredRemote {
    public String openAccount();
    public void deposit(KYC kyc,int amount, Date date);
    public boolean withdraw(KYC kyc,int amount, Date date);
    public void update(KYC kyc);
    public void writeStatements(KYC kyc,String process);
    public void transfer(KYC kyc,int amount, String payee);
}
