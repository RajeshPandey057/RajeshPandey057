import java.util.Scanner;
public class factmain 
{
    static int fact(int n)
    {
        if(n>1)
            return (n*fact(n-1));
        else
            return 1;
    }
    public static void main(String[] s)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=sc.nextInt();
        int i,ans;
        System.out.println("1. for iterative\n2. for recursive");
        int n1=sc.nextInt();
        if(n1==1)
        {
            ans=1;
            for(i=1;i<=n;i++)
                ans*=i;
            System.out.println("Factorial of "+n+" is: "+ans);
        }
        else if(n1==2)
        {
            ans=fact(n);
            System.out.println("Factorial of "+n+" is: "+ans);
        }
        sc.close();
    }
}