package Java;

import java.util.*;
//Simple program tp show multiple inheritance and dynamic method dispatching or runtime polymorphism
class employe
{
    int id;
    String name;
    int rate;
    employe()
    {
        id=0;
        rate=2000;
        name="";
    }
    employe(int did,String dn)
    {
        id=did;
        rate=2000;
        name=dn;
    }

}
class regular extends employe
{
    int nom;
    regular()
    {
        super();
        nom=0;
    }
    regular(int did , String dn,int dnom)
    {
        super(did,dn);
        nom=dnom;
    }
    int pay()
    {
        return nom*30*rate;
    }
}
class daily extends employe
{
    int nod;
    daily()
    {
        super();
        nod=0;
    }
    daily(int did , String dn,int dnod)
    {
        super(did,dn);
        nod=dnod;
    }
    int pay()
    {
        return nod*rate;
    }
}
public class emp
{
    public static void main (String []args)
    {
        daily d1= new daily(057,"Rajesh",50);
        regular r1=new regular(044,"Chintan",2);
        int r=r1.pay();
        int d=d1.pay();
        System.out.println("The pay for regular employe is "+r+" and daily employe is "+d);

    }
}