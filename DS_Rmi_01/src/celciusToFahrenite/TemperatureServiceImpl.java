package celciusToFahrenite;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class TemperatureServiceImpl extends UnicastRemoteObject implements TemperatureService {

    protected TemperatureServiceImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9 / 5) + 32;
    }
}
