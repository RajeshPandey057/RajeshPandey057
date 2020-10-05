#include <stdio.h>
#include <stdlib.h>
#include <sys/sysinfo.h>
#include <string.h>
#include <sys/utsname.h>
int main()
{
    printf("Host A info:\n");
    const double megabyte = 1024 * 1024;
    FILE *ftpr, *f1;
    int days, hours, mins, hostb = 0, hosta;
    struct sysinfo si;
    struct utsname uname_ptr;
    uname(&uname_ptr);
    sysinfo(&si);
    days = si.uptime / 86400;
    hours = (si.uptime / 3600) - (days * 24);
    mins = (si.uptime / 60) - days * 1440 - hours * 60;
    printf("System name: %s\n", uname_ptr.sysname);
    printf("Uptime: %dDays, %dHours, %dminutes, %ldseconds\n", days, hours, mins, si.uptime % 60);
    printf("Process Count: %d\n", si.procs);
    printf("Total RAM: %5.1f MB\n", si.totalram / megabyte);
    printf("Free RAM: %5.1f MB\n", si.freeram / megabyte);
    printf("Load Avarages: 1min(%ld) 5min(%ld) 15min(%ld)\n", si.loads[0], si.loads[1], si.loads[2]);
    char c;
    FILE *fptr;
    int i = system("ssh root4@10.0.2.4 '/./a.out'");
    fptr = fopen("/mnt/info/info.txt", "r");
    printf("\n\nHost B info:\n");
    c = fgetc(fptr);
    while (c != EOF)
    {
        printf("%c", c);
        c = fgetc(fptr);
    }
    fclose(fptr);
    hosta = si.procs;
    f1 = fopen("/mnt/info/pcount.txt", "r");
    c = fgetc(f1);
    while (c != EOF)
    {
        int x = c - '0';
        hostb = hostb * 10 + x;
        c = fgetc(f1);
    }
    fclose(f1);
    printf("\nFollowing Host has least number of processes running:\n");
    if (hosta >= hostb)
        i = system("ssh root4@10.0.2.4 '/load/./a.out'");
    else
        i = system("/load/./a.out");
    return 0;
}
