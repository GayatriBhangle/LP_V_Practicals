package tokenRing;

import java.util.*;

public class TokenRingElection {

    static int n; // Number of processes
    static int[] processes;
    static boolean[] isAlive;
    static int initiator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes in the ring: ");
        n = sc.nextInt();
        processes = new int[n];
        isAlive = new boolean[n];

        System.out.println("Enter the process IDs:");
        for (int i = 0; i < n; i++) {
            processes[i] = sc.nextInt();
            isAlive[i] = true; // Initially all are alive
        }

        System.out.print("Enter the ID of the process initiating the election: ");
        initiator = sc.nextInt();

        startElection(initiator);
    }

    static void startElection(int initiatorId) {
        System.out.println("\nProcess " + initiatorId + " starts the ELECTION!");

        List<Integer> electionMessage = new ArrayList<>();
        int currentIndex = findIndex(initiatorId);
        int startIndex = currentIndex;

        // Circulate the election message around the ring
        do {
            if (isAlive[currentIndex]) {
                System.out.println("Process " + processes[currentIndex] + " adds itself to election message.");
                electionMessage.add(processes[currentIndex]);
            }
            currentIndex = (currentIndex + 1) % n; // Move to next process in ring
        } while (currentIndex != startIndex);

        // Find the process with highest ID (winner)
        int newCoordinator = Collections.max(electionMessage);

        System.out.println("\nElection completed. New COORDINATOR is Process " + newCoordinator);

        // Start coordinator announcement
        announceCoordinator(newCoordinator);
    }

    static void announceCoordinator(int coordinatorId) {
        int currentIndex = findIndex(coordinatorId);
        int startIndex = currentIndex;

        System.out.println("\nCoordinator Announcement Phase:");

        do {
            if (isAlive[currentIndex]) {
                System.out.println("Process " + processes[currentIndex] + " acknowledges new Coordinator " + coordinatorId);
            }
            currentIndex = (currentIndex + 1) % n;
        } while (currentIndex != startIndex);
    }

    static int findIndex(int id) {
        for (int i = 0; i < n; i++) {
            if (processes[i] == id) return i;
        }
        return -1;
    }
}
