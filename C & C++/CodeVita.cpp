#include <iostream>
#include<math.h>
using namespace std;

int main()
{
    int t, i, j;

    //number of test cases
    cin>>t;
    long *n=new long[t];
    for(i=0; i<t; i++)
    {
        //integer input
        cin>>n[i];
    }
    for(i=0; i<t; i++)
    {
        int temp[sqrt(n[i])];
        int c=0;
       for(j=1; j<=sqrt(n[i]); j++)
        {
            if(n[i]%j==0)
            {
                if(n[i]/j==j) cout<<j<<" ";
                else {cout<<j<<" "; n[]}
            }
        }
        cout<<endl;
    }

    return 0;
}
