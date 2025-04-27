package berkelyClockSync;

import java.io.*;
import java.net.*;
import java.util.*;

public class MasterServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Master started... Waiting for clients...");

        List<Socket> clients = new ArrayList<>();
        List<Integer> clientTimes = new ArrayList<>();

        // Accept 3 clients for this example
        for (int i = 0; i < 3; i++) {
            Socket client = serverSocket.accept();
            clients.add(client);
            System.out.println("Client " + (i+1) + " connected.");
        }

        // Step 1: Ask all clients for their time
        for (Socket client : clients) {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF("SendTime");
        }

        // Step 2: Receive times from clients
        for (Socket client : clients) {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            int clientTime = dis.readInt();
            clientTimes.add(clientTime);
            System.out.println("Received time: " + clientTime + " from client");
        }

        // Step 3: Compute average
        int masterTime = (int) (System.currentTimeMillis() / 1000);  // master current time
        clientTimes.add(masterTime);
        int sum = 0;
        for (int time : clientTimes) {
            sum += time;
        }
        int avgTime = sum / clientTimes.size();
        System.out.println("Average Time = " + avgTime);

        // Step 4: Send adjustment to clients
        for (Socket client : clients) {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(avgTime);
        }

        System.out.println("Adjustments sent to all clients.");

        // Close connections
        for (Socket client : clients) {
            client.close();
        }
        serverSocket.close();
    }
}
