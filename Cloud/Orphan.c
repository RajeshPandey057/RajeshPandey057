#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main()
{
    int pid = fork();
    if (pid > 0)
        printf("in parent process\n Returning parent process to make ld orphan");
    else if (pid == 0)
    {
        printf("in child process");
        sleep(30);
        printf("Unreachable");
    }
    return 0;
}