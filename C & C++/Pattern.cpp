#include<iostream>
#include<cmath>
using namespace std;
int main()
{
       int n;
       cin>>n;
        double a1=10,a2=0,a3=0,a4=0;
        for(int i=0;i<n;i++){
            if(i==0){
                for(int j=0;j<n;j++){
                    cout<<abs(a1);
                    a1+=10;
                }
                a2=(a1-10)*((a1-10)/10)+10;
                a4=a2;
                for(int j=0;j<n-1;j++){
                    cout<<abs(a2);
                    a2+=10;
                }
                a3=(a2-10)/10 + 1;
                cout<<abs(a3);
            }
            else {
                for(int j=0;j<i;j++){
                    cout<<"**";
                }
                for(int j=0;j<(n-i);j++){
                    cout<<abs(a1);
                    a1+=10;
                }
                a2=a4-(n-i)*10;
                a4=a2;
                for(int j=0;j<(n-i-1);j++){
                cout<<abs(a2);
                    a2+=10;
                }
                a3=a3-(n-i+1);
                cout<<abs(a3);
            }
                cout<<endl;
        }
    }
