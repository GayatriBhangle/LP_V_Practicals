package celciusToFahrenite;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try {
            // Replace "localhost" with server IP if running on different machines
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TemperatureService service = (TemperatureService) registry.lookup("TemperatureService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter Celsius Temperature (or type exit): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                double celsius = Double.parseDouble(input);
                double fahrenheit = service.celsiusToFahrenheit(celsius);
                System.out.println("Fahrenheit: " + fahrenheit);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
