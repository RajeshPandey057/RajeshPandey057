#include<iostream>
using namespace std;
void s_sort(int a[],int b[],int n)
{
	int temp,i,j;//Decalaration

	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(a[i]>a[j])
			{
				temp=a[j];//First Array Swapping
				a[j]=a[i];
				a[i]=temp;
				temp=b[j];//Second array swapping
				b[j]=b[i];
				b[i]=temp;
			}
		}
	}
}
void s_sort(float a[],int b[],int n)///////Overloading
{
	int temp,i,j;

	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(a[i]>a[j])
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
	start:
	int c,p,q=100;
	int w[6]={10,30,5,66,40,50};//Weight Factor
	int v[6]={20,10,5,66,60,50};//Value Factor
	int i[6]={0,1,2,3,4,5};//Index 
	float vw[6];//Value to Weight Ratio
	for(p=0;p<6;p++)
	{
		vw[p]=float(v[p])/float(w[p]);//Ratio
		
	}
	cout<<"Choose From the following\n";//Interactive
	cin>>c;
	switch(c)
	{
		case 1://For weight based greedy
			s_sort(w,i,6);
			for(p=0;p<6;p++)
			{
				if(q<=w[p]) break;
				else q=q-w[p];
				cout<<i[p]<<endl;
			}
			break;
		case 2://For value Based Greedy
			s_sort(v,i,6);
			for(p=0;p<6;p++)
			{
				if(q<=w[i[p]]) break;
				else q=q-w[i[p]];
				cout<<i[p]<<endl;
			}
			break;
		case 3://For Value to Weight Greedy
			s_sort(vw,i,6);
			for(p=0;p<6;p++)
			{
				if(q<=w[i[p]]) break;
				else q=q-w[i[p]];
				cout<<i[p]<<endl;
			}
			break;
		default:
			cout<<"Invalid choise\n";
			break;
	}
	cin>>c;
	if(c==0) return 0;
	else goto start;
}

		

