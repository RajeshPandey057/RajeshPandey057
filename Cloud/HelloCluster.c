#include <stdio.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    int myrank, nprocs;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nprocs);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);

    printf("HELLO WORLD!from processor %d\n", myrank + 1);

    MPI_Finalize();
    return 0;
}
