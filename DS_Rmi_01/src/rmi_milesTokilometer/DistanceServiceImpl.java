package rmi_milesTokilometer;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class DistanceServiceImpl extends UnicastRemoteObject implements DistanceService {

    protected DistanceServiceImpl() throws RemoteException {
        super();
    }

    public double milesToKilometers(double miles) throws RemoteException {
        return miles * 1.60934;
    }
}
