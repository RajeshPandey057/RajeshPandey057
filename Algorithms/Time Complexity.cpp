#include<iostream>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;
void bubble(int *a,int n)
{
    int i,j,temp;
    for(j=0;j<(n-1);j++)
    {
        for(i=j+1;i<n;i++)
        {
            if(a[i]<a[j])
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
    }
}
void selection(int *a,int n)
{
    int i,j,temp,t2,mini;
    for(j=0;j<(n-1);j++)
    {
        mini=a[j];
        for(i=j+1;i<n;i++)
        {
            if(a[i]<mini)
            {
                t2=i;
                mini=a[i];
            }
        }
        temp=a[t2];
        a[t2]=a[j];
        a[j]=temp;
    }
}
void insertion(int *a,int n)
{
    int i,j,key,t1;
    for(i=1;i<n;i++)
    {
        t1=i;
        for(j=i-1;j>=0;j--)
        {
            if(a[j]>a[i])
            {
                key=a[i];
                a[i]=a[j];
                a[j]=key;
                i=j;
            }
            else
                break;
        }
        i=t1;
    }
}
void datagen(int *a,int *b,int *c,int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        a[i]=i;
    }
    for(i=0;i<n;i++)
    {
        b[i]=n-i;
    }
    for(i=0;i<n;i++)
    {
        c[i]=rand();
    }


}
int main(int argc, char **argv)
{
    int n;
    cin>>n;
    int *a=new int[n];
    int *b=new int[n];
    int *c=new int[n];
    datagen(a,b,c,n);
    struct timeval start, end;
    gettimeofday(&start, NULL);
    bubble(a,n);
    gettimeofday(&end, NULL);
    cout<<"For bubble sort:\n";
    cout<<"\tFor best case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    bubble(b,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor worst case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    bubble(c,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor random case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));

    delete a;
    delete b;
    delete c;
    a=new int[n];
    b=new int[n];
    c=new int[n];
    datagen(a,b,c,n);
    gettimeofday(&start, NULL);
    insertion(a,n);
    gettimeofday(&end, NULL);
    cout<<"For insertion sort:\n";
    cout<<"\tFor best case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    insertion(b,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor worst case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    insertion(c,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor random case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    return 0;
}
