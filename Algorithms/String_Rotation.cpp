#include<iostream>
#include<string.h>
#include<algorithm>
using namespace std;
bool ana(string s1, string s2)
{
    sort(s1.begin(),s1.end());
    sort(s2.begin(),s2.end());
    return int(s1==s2);
}
int main()
{
    string s;
    char a[100];
    int q,i,j,n,k,t1;
    cin>>s;
    cin>>q;
    char d[q];
    int r[q];
    for(i=0;i<q;i++)
    {
        cin>>d[i];
        cin>>r[i];
    }
    j=0;
    k=0;
    n=s.length();
    for(i=0;i<q;i++)
    {
        if(d[i]=='L')
        {
            j+=r[i];
            while(j>=n)
                j-=n;
            t1=int(s[j]);
            a[k++]=t1;
        }
        else if(d[i]=='R')
        {
            j-=r[i];
            while(j<=0)
                j+=n;
            t1=int(s[j]);
            a[k++]=t1;
        }
    }
    string a1;
    a1=string(a);
    cout<<a1<<endl;
    int f=0;
    string b;
    for(i=0;i<=(n-q);i++)
    {
        b=s.substr(i,q);
        if(ana(b,a1)==1)
        {
            f=1;
            break;
        }
    }
    if(f==1)
        cout<<"YES";
    else
        cout<<"NO";
    return 0;
}
