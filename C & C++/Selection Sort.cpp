#include<iostream>
using namespace std;
void ssort(float a[],int b[],int n)
{
	int temp,i,j;

	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(a[i]<a[j])
			{
				temp=a[j];
				a[j]=a[i];
				a[i]=temp;
				temp=b[j];
				b[j]=b[i];
				b[i]=temp;
			}
		}
	}
}
int main()
{
    int m,i,j;
    int *p,*q,*l,*t;
    int *in;
    float *r2;
    string *sn;
    cout<<"Enter money you have:\n";
    cin>>m;
    int n;
    cout<<"Enter total dishes:\n";
    cin>>n;
    sn=new string[n];
    p=new int[n];
    q=new int[n];
    l=new int[n];
    t=new int[n];
    in=new int[n];
    r2=new float[n];
    for(i=0;i<n;i++)
    {
        in[i]=i;//for indexing
    }
    float q1,l1,t1;
    cout<<"Enter fraction priority for \n| quantity | taste | service time |\n";
    cin>>q1>>l1>>t1;
    cout<<"Enter \n| name | | price | quantity | taste | service time |\n";
    for(i=0;i<n;i++)
    {
        cin>>sn[i]>>p[i]>>q[i]>>l[i]>>t[i];
        r2[i]=((q1*q[i])+(l1*l[i])+(t1*t[i]))/p[i];
    }
    ssort(r2,in,n);
    int total=0;
    for(i=0;i<n;i++)
    {
        if(m<p[in[i]])  break;
        else
        {
            m-=p[in[i]];
            cout<<"Order Dish "<<sn[i]<<" having price Rs. "<<p[in[i]]<<endl;
            total=total+p[in[i]];
        }
    }
    cout<<"Pay Rs."<<total<<endl;
    return 0;
}
