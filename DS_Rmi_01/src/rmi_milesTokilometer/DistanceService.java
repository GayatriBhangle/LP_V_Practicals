package rmi_milesTokilometer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DistanceService extends Remote {
    double milesToKilometers(double miles) throws RemoteException;
}
