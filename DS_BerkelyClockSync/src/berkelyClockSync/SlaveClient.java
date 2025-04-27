package berkelyClockSync;

import java.io.*;
import java.net.*;
import java.util.Random;

public class SlaveClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to Master...");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Simulate random local time
        int localTime = (int) (System.currentTimeMillis() / 1000) + new Random().nextInt(10) - 5;
        System.out.println("Local Time: " + localTime);

        while (true) {
            String message = dis.readUTF();
            if (message.equals("SendTime")) {
                // Step 1: Send local time to master
                dos.writeInt(localTime);
            }

            // Step 2: Receive updated time
            int newTime = dis.readInt();
            System.out.println("Adjusted Local Time: " + newTime);
            break;
        }

        socket.close();
    }
}
