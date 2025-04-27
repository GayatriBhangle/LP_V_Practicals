package bullyalgo;

import java.util.Scanner;

public class BullyLeaderElection {

    static int numberOfProcesses;
    static int[] processIds;
    static boolean[] isAlive;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        numberOfProcesses = sc.nextInt();

        processIds = new int[numberOfProcesses];
        isAlive = new boolean[numberOfProcesses];

        System.out.println("Enter process IDs:");
        for (int i = 0; i < numberOfProcesses; i++) {
            processIds[i] = sc.nextInt();
            isAlive[i] = true; // initially all processes are alive
        }

        System.out.print("Enter the ID of the process detecting coordinator failure: ");
        int initiatorId = sc.nextInt();

        startElection(initiatorId);
    }

    static void startElection(int initiatorId) {
        int initiatorIndex = findProcessIndex(initiatorId);

        System.out.println("\nProcess " + initiatorId + " starts an ELECTION!");

        boolean higherProcessExists = false;

        // Send election messages to all higher ID processes
        for (int i = initiatorIndex + 1; i < numberOfProcesses; i++) {
            if (isAlive[i]) {
                System.out.println("Process " + processIds[initiatorIndex] + " sends ELECTION message to Process " + processIds[i]);
                higherProcessExists = true;
            }
        }

        if (!higherProcessExists) {
            // No higher processes alive — become coordinator
            declareCoordinator(initiatorId);
        } else {
            // Higher process responds and starts its own election
            for (int i = initiatorIndex + 1; i < numberOfProcesses; i++) {
                if (isAlive[i]) {
                    startElection(processIds[i]);
                    break;
                }
            }
        }
    }

    static void declareCoordinator(int coordinatorId) {
        int coordinatorIndex = findProcessIndex(coordinatorId);

        System.out.println("\nProcess " + coordinatorId + " becomes the NEW COORDINATOR!");

        // Send coordinator message to all lower processes
        for (int i = 0; i < numberOfProcesses; i++) {
            if (i != coordinatorIndex && isAlive[i]) {
                System.out.println("Process " + coordinatorId + " sends COORDINATOR message to Process " + processIds[i]);
            }
        }
    }

    static int findProcessIndex(int id) {
        for (int i = 0; i < numberOfProcesses; i++) {
            if (processIds[i] == id) return i;
        }
        return -1;
    }
}
