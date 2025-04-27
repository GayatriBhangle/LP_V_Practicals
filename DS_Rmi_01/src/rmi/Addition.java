package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Addition extends Remote {
    int addNumbers(int a, int b) throws RemoteException;
}
