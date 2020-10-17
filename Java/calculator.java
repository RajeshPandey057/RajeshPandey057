package Java;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
	<applet code="changetext" width=500 height=500>
	</applet>
*/
public class calculator extends Applet implements ActionListener

{
	TextField t1;
	TextField t2;
	TextField t3;
	public void init()
	{
		Label l1=new Label("=");
		Button pl=new Button("+");
		Button sb=new Button("-");
		Button ml=new Button("*");
		Button dv=new Button("/");
		t1=new TextField(7);
		t2=new TextField(7);
		t3=new TextField(7);
		add(t1);
		add(pl);
		add(sb);
		add(ml);
		add(dv);
		add(t2);
		add(l1);
		add(t3);
		pl.addActionListener(this);
		sb.addActionListener(this);
		ml.addActionListener(this);
		dv.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		int n1=Integer.parseInt(t1.getText());
		int n2=Integer.parseInt(t2.getText());
		String op=ae.getActionCommand();
		if(op.equals("+"))
		{
			t3.setText(""+(n1+n2));
		}
		else if(op.equals("-"))
		{
			t3.setText(""+(n1-n2));
		}
		else if(op.equals("*"))
		{
			t3.setText(""+(n1*n2));
		}
		else if(op.equals("/"))
		{
			t3.setText(""+(n1/n2));
		}
	}
}
