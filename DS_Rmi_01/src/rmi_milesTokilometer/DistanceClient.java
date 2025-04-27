package rmi_milesTokilometer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class DistanceClient {
    public static void main(String[] args) {
        try {
            // Replace "localhost" with server IP if on different machines
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DistanceService service = (DistanceService) registry.lookup("DistanceService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter Distance in Miles (or type exit): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                double miles = Double.parseDouble(input);
                double kilometers = service.milesToKilometers(miles);
                System.out.println("Kilometers: " + kilometers);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
