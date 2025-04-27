package celciusToFahrenite;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            // Create registry programmatically
            LocateRegistry.createRegistry(1099);
            // Create service instance
            TemperatureService service = new TemperatureServiceImpl();
            // Bind the service
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("TemperatureService", service);
            System.out.println("Temperature Conversion Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
