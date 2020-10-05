#include <stdio.h>
#include <sys/sysinfo.h>
#include <stdlib.h>
#include <string.h>
#include <sys/utsname.h>
int main()
{
    const double megabyte = 1024 * 1024;
    FILE *ftpr, *f1;
    int days, hours, mins;
    ftpr = fopen("/mnt/sharedfolder/info.txt", "w");
    struct sysinfo si;
    struct utsname uname_ptr;
    uname(&uname_ptr);
    sysinfo(&si);
    days = si.uptime / 86400;
    hours = (si.uptime / 3600) - (days * 24);
    mins = (si.uptime / 60) - days * 1440 - hours * 60;
    fprintf(ftpr, "System name: %s\n", uname_ptr.sysname);
    fprintf(ftpr, "Uptime: %dDays, %dHours, %dminutes, %ldseconds\n", days, hours, mins, si.uptime % 60);
    fprintf(ftpr, "Process Count: %d\n", si.procs);
    fprintf(ftpr, "Total RAM: %5.1f MB\n", si.totalram / megabyte);
    fprintf(ftpr, "Free RAM: %5.1f MB\n", si.freeram / megabyte);
    fprintf(ftpr, "Load Avarages: 1min(%ld) 5min(%ld) 15min(%ld)\n", si.loads[0], si.loads[1], si.loads[2]);
    fclose(ftpr);
    f1 = fopen("/mnt/sharedfolder/pcount.txt", "w");
    fprintf(f1, "%d", si.procs);
    fclose(f1);
    return 0;
}
