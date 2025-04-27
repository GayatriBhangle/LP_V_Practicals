package mpi;

import mpi.*;

public class DistributedSumMPI {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank(); // Each process ID
        int size = MPI.COMM_WORLD.Size(); // Total number of processes

        int[] data = new int[size]; // Array to be distributed

        if (rank == 0) {
            // Root process initializes the array
            for (int i = 0; i < size; i++) {
                data[i] = i + 1; // Example: [1,2,3,...]
            }
            System.out.println("Root Process - Initial Array:");
            for (int val : data) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Buffer to receive one element at each worker
        int[] recvBuf = new int[1];

        // Scatter the array: root sends one element to each process
        MPI.COMM_WORLD.Scatter(data, 0, 1, MPI.INT, recvBuf, 0, 1, MPI.INT, 0);

        // Each process computes its intermediate sum
        int intermediateSum = recvBuf[0] * 2; // (Simple: multiply element by 2, or apply your custom logic)

        System.out.println("Process " + rank + " received " + recvBuf[0] + ", intermediate sum: " + intermediateSum);

        MPI.Finalize();
    }
}
