import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
	<applet code="cal" width=500 height=500>
	</applet>
*/
public class cal extends Applet implements ActionListener
{	
	TextField t1,t2,t3;
	public void init()
	{
		Button pl=new Button("+");
		Button mi=new Button("-");
		Button di=new Button("/");
		Button mu=new Button("*");
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		add(t1);
		add(t2);
		add(pl);
		add(mi);
		add(mu);
		add(di);
		add(t3);
		pl.addActionListener(this);
		mi.addActionListener(this);
		mu.addActionListener(this);
		di.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String b=ae.getActionCommand();
		String num1=t1.getText();
		String num2=t2.getText();
		int a,c;
		a=Integer.parseInt(num1);
		c=Integer.parseInt(num2);
		int ans;
		if(b.equals("+"))
		{
			t3.setText(""+(a+c));
		}
		else if(b.equals("-"))
		{
			t3.setText(""+(a-c));
		}
		else if(b.equals("*"))
		{
			t3.setText(""+(a*c));
		}
		else if(b.equals("/"))
		{
			t3.setText(""+(a/c));
		}
			
	}
}