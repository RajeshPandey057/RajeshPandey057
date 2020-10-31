class bufffer
{
    volatile int turn=0;
    int ar[];
    int n;
    int ds=2;
    bufffer(int dn)
    {
        n=dn;
        ar=new int[n];
        ar[0]=0;
        ar[1]=1;
    }
    synchronized void fibb(int dturn,int end)
    {
        while (turn!=dturn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        turn=turn+1;
        int dend=ds+end;
        if(dend>=n) dend=n-1;
        for (int i=ds;i<=dend;i++)
        {
            ar[i]=ar[i-1]+ar[i-2];
        }
        ds+=end;
        notifyAll();
    }
}
class calfibb extends Thread
{
    int myturn;
    bufffer bref;
    int end;
    calfibb(String name,int d,int dend,bufffer db)
    {
        super(name);
        myturn=d;
        bref=db;
        end=dend;
        start();
    }
    public void run()
    {
        bref.fibb(myturn,end);
    }
}
class assignment3even
{
    public static void main(String[] args)
    {
        bufffer br=new bufffer(30);
        calfibb th1=new calfibb("first",0,10,br);
        calfibb th2=new calfibb("second",1,10,br);
        calfibb th3=new calfibb("third",2,10,br);
        try
        {
            th1.join();
            th2.join();
            th3.join();
        }
        catch (InterruptedException e)
        {
            System.out.println(""+e);
        }
        for(int i=0;i<30;i++)
        {
            System.out.print("\t"+br.ar[i]);
        }
    }
}
