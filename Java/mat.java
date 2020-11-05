import java.util.*;
class matrix
{
    int m;
    int n;
    int[][] d;
    matrix()
    {
        System.out.println("Enter The Diamentions of matrix");
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        d=new int[m][n];
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the m[" + (i+1) + "][" + (j+1) + "]th Element");
                d[i][j] = sc.nextInt();
            }
        }

    }
    matrix(int dm,int dn)
    {
        m=dm;
        n=dn;
        d=new int[m][n];
    }
    matrix add(matrix dm)
    {
        if(m!=dm.m || n!=dm.n) return this;
        else
        {
            matrix p=new matrix(m,n);
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    p.d[i][j]=d[i][j]+dm.d[i][j];
                }
            }
            return p;
        }
    }
    matrix trans()
    {
        matrix dm=new matrix(m,n);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dm.d[i][j]=d[j][i];
            }
        }
        return dm;
    }
    matrix mul(matrix dm)
    {
        if(n!=dm.m) return this;
        else {
            matrix p = new matrix(m,dm.n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < dm.n; j++) {
                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        sum = sum + d[i][k] * dm.d[k][j];
                    }
                    p.d[i][j] = sum;
                }
            }
            return p;
        }
    }
    void display()
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(d[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");

        }
    }
}
public class mat
{
    public static void main(String[] args)
    {
        matrix m1=new matrix();
        matrix m2=new matrix();
        m1.display();
        m2.display();
        matrix m3=m1.add(m2);
        matrix m4=m1.trans();
        matrix m5=m1.mul(m2);
        m3.display();
        m4.display();
        m5.display();

    }
}
