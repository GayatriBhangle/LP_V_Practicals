package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AdditionClient {
    public static void main(String[] args) {
        try {
            // Replace "server-ip" with actual server IP address
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Addition stub = (Addition) registry.lookup("AdditionService");
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter two numbers: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = stub.addNumbers(a, b);

            System.out.println("Addition of " + a + " and " + b + " is: " + result);
        } catch (Exception e) {
            System.out.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
