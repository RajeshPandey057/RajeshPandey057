#include<iostream>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>
#include <stdio.h>
using namespace std;
void bubble(int arr[],int n)
{
   int i, temp,j;
   bool swapped;
   for (i = 0; i < n-1; i++)
   {
     swapped = false;
     for (j = 0; j < n-i-1; j++)
     {
        if (arr[j] > arr[j+1])
        {
           temp=arr[j];
           arr[j]=arr[j+1];
           arr[j+1]=temp;
           swapped = true;
        }
     }

     // IF no two elements were swapped by inner loop, then break
     if (swapped == false)
        break;
   }
}
void selection(int arr[],int n)
{
   int i, temp,j, min_idx;

    // One by one move boundary of unsorted subarray
    for (i = 0; i < n-1; i++)
    {
        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i+1; j < n; j++)
          if (arr[j] < arr[min_idx])
            min_idx = j;

        // Swap the found minimum element with the first element
        temp=arr[i];
           arr[i]=arr[min_idx];
           arr[min_idx]=temp;
    }
}
void insertion(int arr[],int n)
{
    int i, key, j;
   for (i = 1; i < n; i++)
   {
       key = arr[i];
       j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
       while (j >= 0 && arr[j] > key)
       {
           arr[j+1] = arr[j];
           j = j-1;
       }
       arr[j+1] = key;
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

    delete a;
    delete b;
    delete c;
    a=new int[n];
    b=new int[n];
    c=new int[n];
    datagen(a,b,c,n);
    gettimeofday(&start, NULL);
    selection(a,n);
    gettimeofday(&end, NULL);
    cout<<"For selection sort:\n";
    cout<<"\tFor best case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    selection(b,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor worst case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    gettimeofday(&start, NULL);
    selection(c,n);
    gettimeofday(&end, NULL);
    cout<<"\tFor random case:\n";
    printf("\t\t%ld\n", ((end.tv_sec * 1000000 + end.tv_usec)- (start.tv_sec * 1000000 + start.tv_usec)));
    return 0;
}
