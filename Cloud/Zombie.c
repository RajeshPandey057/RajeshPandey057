#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
int main()
{
    pid_t child_pid = fork();
    if (child_pid > 0)
        sleep(50);
    else
    {
        printf("Exiting Child process, making main Zombie");
        exit(0);
    }
    printf("Child Completed but main is sleeping, unreachable");
    return 0;
}