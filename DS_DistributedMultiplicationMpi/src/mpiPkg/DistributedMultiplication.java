package mpiPkg;
import mpi.*;

public class DistributedMultiplication{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int[] data = new int[size];

        if (rank == 0) {
            // Root process initializes array
            for (int i = 0; i < size; i++) {
                data[i] = i + 1; // Example: [1, 2, 3, 4,...]
            }
            System.out.println("Root Process initialized array:");
            for (int val : data) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        int[] recvBuf = new int[1];

        // Scatter data to all processes
        MPI.COMM_WORLD.Scatter(data, 0, 1, MPI.INT, recvBuf, 0, 1, MPI.INT, 0);

        // Each process computes multiplication
        int intermediateMultiplication = recvBuf[0] * recvBuf[0]; // example: square

        System.out.println("Process " + rank + " received " + recvBuf[0] +
                           ", Intermediate Multiplication: " + intermediateMultiplication);

        MPI.Finalize();
    }
}
