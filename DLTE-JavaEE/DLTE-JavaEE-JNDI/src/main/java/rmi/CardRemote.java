package rmi;

import java.rmi.Remote;

public interface CardRemote extends Remote {
    void search(int limit);
}
