#include <stdio.h>
#include <unistd.h>
int main()
{
    int pipefds[2];
    int returnstatus, n1, n2, temp, temp2, i, sum = 0;
    char writemessages[20], readmessage[20];
    returnstatus = pipe(pipefds);
    if (returnstatus == -1)
    {
        printf("Unable to create pipe\n");
        return 1;
    }
    n1 = fork();
    n2 = fork();
    if (n1 > 0 && n2 > 0)
    {
        sum = 0;
        for (i = 76; i < 101; i++)
        {
            sum += i;
        } //Add 0-25 in variable sum in First process 18.
        temp = sum;
        read(pipefds[0], readmessage, sizeof(readmessage));
        sscanf(readmessage, "%d", &temp2);
        sum += temp2;
        printf("Forth Process\n - Reading from pipe – Sum(0,25)=%s\n", readmessage);
        read(pipefds[0], readmessage, sizeof(readmessage));
        sscanf(readmessage, "%d", &temp2);
        sum += temp2;
        printf(" - Reading from pipe – Sum(26,50)=%s\n", readmessage);
        read(pipefds[0], readmessage, sizeof(readmessage));
        sscanf(readmessage, "%d", &temp2);
        sum += temp2;
        printf(" - Reading from pipe – Sum(51,75)=%s\n", readmessage);
        printf(" - Calculating Sum(76,100)= %d\n", temp);
        printf(" - Adding 0-100...\n");
        printf("\nSum(0,100)=%d\n", sum);
    }
    else if (n1 == 0 && n2 > 0)
    {
        sum = 0;
        printf("First Process\n - Adding 0-25...\n");
        for (i = 0; i < 26; i++)
        {
            sum += i;
        }                                  //Add 0-25 in variable sum in First process
        sprintf(writemessages, "%d", sum); //Convert to String
        printf(" - Writing to pipe - Sum(0,25)= %s\n", writemessages);
        write(pipefds[1], writemessages, sizeof(writemessages));
        printf(" - Exiting First Process\n\n");
    }
    else if (n1 > 0 && n2 == 0)
    {
        sum = 0;
        printf("Second Process\n - Adding 26-50...\n");
        for (i = 26; i < 51; i++)
        {
            sum += i;
        }                                  //Add 26-50 in variable sum in First process
        sprintf(writemessages, "%d", sum); //Convert to String
        printf(" - Writing to pipe - Sum(26,50)= %s\n", writemessages);
        write(pipefds[1], writemessages, sizeof(writemessages));
        printf(" - Exiting Second Process\n\n");
    }
    else
    {
        sum = 0;
        printf("Third Process\n - Adding 51-75...\n");
        for (i = 51; i < 76; i++)
        {
            sum += i;
        }                                  //Add 51-75 in variable sum in First process
        sprintf(writemessages, "%d", sum); //Convert to String
        printf(" - Writing to pipe - Sum(51,75)= %s\n", writemessages);
        write(pipefds[1], writemessages, sizeof(writemessages));
        printf(" - Exiting Third Process\n\n");
    }
    return 0;
}