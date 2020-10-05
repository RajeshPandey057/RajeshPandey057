//Maximum using two processes from array of 100 random numbers
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <stdio.h>
int myprocessfork(int x)
{
    int j;
    for (j = 1; j < x; j++)
    {
        if (fork() == 0)
            return j;
    }
    return 0;
}
void myprocessjoin(int x, int id)
{
    int i;
    if (id == 0)
    {
        for (i = 1; i < x; i++)
        {
            wait(0);
        }
    }
    else
    {
        exit(0);
    }
}
int main()
{
    int a[100];
    for (int i = 0; i < 100; i++)
    {
        a[i] = rand();
    }
    int max1 = 0, max = 0;
    int *max2;
    int shmid;
    shmid = shmget(IPC_PRIVATE, sizeof(int), IPC_CREAT | SHM_R | SHM_W);
    max2 = (int *)shmat(shmid, 0, 0);
    int id, i;
    id = myprocessfork(2);
    if (id == 0)
    {
        int temp = -1;
        for (i = 0; i < 100; i = i + 2)
        {
            if (a[i] > temp)
                temp = a[i];
        }
        max1 = temp;
        printf("Parent MAX : %d\n", max1);
    }
    else
    {
        int temp = -1;
        for (i = 1; i < 100; i = i + 2)
        {
            if (a[i] > temp)
                temp = a[i];
        }
        *max2 = temp;
        printf("Child Max : %d\n", *max2);
    }
    myprocessjoin(2, id);
    max = (max1 > *max2) ? max1 : *max2;
    printf("Final Max is : %d\n", max);
    return 0;
}
