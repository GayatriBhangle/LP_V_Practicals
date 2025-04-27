package rmi_milesTokilometer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DistanceServer {
    public static void main(String[] args) {
        try {
            // Create registry programmatically
            LocateRegistry.createRegistry(1099);
            // Create service instance
            DistanceService service = new DistanceServiceImpl();
            // Bind the service
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("DistanceService", service);
            System.out.println("Miles to Kilometers Conversion Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
