package mutualEx;

public class TokenRingMutualExclusion {

    static class Process extends Thread {
        private int id;
        private int totalProcesses;
        private static volatile int tokenHolder = 0; // Who currently has the token (shared)
        private static Object lock = new Object();

        public Process(int id, int totalProcesses) {
            this.id = id;
            this.totalProcesses = totalProcesses;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (tokenHolder == id) {
                        System.out.println("Process " + id + " has the token and is entering Critical Section.");
                        try {
                            // Simulate some work inside CS
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Process " + id + " leaving Critical Section.");

                        // Pass token to next process
                        tokenHolder = (id + 1) % totalProcesses;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int totalProcesses = 5; // Let's simulate 5 processes

        for (int i = 0; i < totalProcesses; i++) {
            new Process(i, totalProcesses).start();
        }
    }
}
