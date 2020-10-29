import java.util.Scanner;
class complex 
{
    int r,i;
    complex()
    {
        r=0;
        i=0;
    }
    complex(int dr, int di)
    {
        r=dr;
        i=di;
    }
    complex addcomplex(complex c2)
    {
        complex c = new complex();
        c.r = r + c2.r;
        c.i = i + c2.i;
        return c;
    }
    void display()
    {
        if(i>=0)
            System.out.println(""+r+"+"+i+"i");
        else
            System.out.println(""+r+""+i+"i");
    }
}
public class complexmain {
    public static void main(String[] s)
    {
        Scanner sc = new Scanner(System.in);
        int n1,n2,n3,n4;
        System.out.println("Enter first complex number: ");
        n1=sc.nextInt();
        n2=sc.nextInt();
        System.out.println("Enter second complex number: ");
        n3=sc.nextInt();
        n4=sc.nextInt();
        complex c1 = new complex(n1,n2);
        complex c2 = new complex(n3,n4);
        complex c = new complex();
        c=c1.addcomplex(c2);
        c.display();
    }
}
