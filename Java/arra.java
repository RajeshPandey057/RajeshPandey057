import java.util.Scanner;
class complex1
{
    int r;
    int j;
    complex1()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Real and imaginary part");
        r=sc.nextInt();
        j=sc.nextInt();
    }

    complex1(int dr, int dj) {
        r = dr;
        j = dj;
    }
    void display() {
        System.out.println(r+"+"+j+"i");
    }
}
public class arra
{
    public static void main(String[] arg)
    {
        complex1[] c = new complex1[5];
        for (int i = 0; i < 5; i++) {
          c[i]=new complex1();
        }
        for (int i = 0; i < 5; i++) {
            c[i].display();
        }


    }
}