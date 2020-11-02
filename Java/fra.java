import java.util.Scanner;
class fra
{
    public static void main(String []args)
    {
        int i,n,a=1;
        System.out.println("Enter no:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            a=a*i;
        }
        System.out.println(n+"!="+a);
    };
};
