package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class AdditionImpl extends UnicastRemoteObject implements Addition {

    protected AdditionImpl() throws RemoteException {
        super();
    }

    public int addNumbers(int a, int b) throws RemoteException {
        return a + b;
    }
}
