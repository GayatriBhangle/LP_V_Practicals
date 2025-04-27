package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionServer {
    public static void main(String[] args) {
        try {
            AdditionImpl obj = new AdditionImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // 1099 is default RMI port
            registry.rebind("AdditionService", obj);
            System.out.println("Addition Server is ready...");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
