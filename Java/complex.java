import java.util.Scanner;
class c
{
	void add(int a,int b, int c, int d)
	{
		System.out.println("The sum of complex number is" +(a+c)+ "+i"+(b+d));	
	}	
}
class complex
{
	public static void main(String [] args)
	{
		int a,b,c,d;
		Scanner s=new Scanner(System.in);
		
		System.out.println("enter a and b:");
		a=s.nextInt();
		b=s.nextInt();
		
		System.out.println("The 1st complex number is" +a+ "+i"+b);
	
		System.out.println("enter c and d:");
		c=s.nextInt();
		d=s.nextInt();

		System.out.println("The 2nd complex number is" +c+ "+i"+d);
		
		complex cc;
		cc=new c();
		int w=cc.add(a,b,c,d);		
	}
}