import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class calc extends Applet implements ActionListener
{
	TextField A1,A2;
	Label l1,l2,A;
	public void init()
	{
		Button p=new Button("+");
		Button s=new Button("-");
		Button d=new Button("*");
		Button m=new Button("/");
		A1=new TextField(10);
		A2=new TextField(10);
		l1=new Label("Arg1");
		l2=new Label("Arg2");
		add(l1);
		add(A1);
		add(l2);
		add(A2);
		add(A);
		add(p);
		add(s);
		add(m);
		add(d);
		p.addActionListener(this);
		s.addActionListener(this);
		m.addActionListener(this);
		d.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String r=ae.getActionCommand();
		int a,b;
		a=Integer.parseInt(A1.getText());
		b=Integer.parseInt(A2.getText());
		String an=new String();
		if(r.equals("+")) an=""+(a+b);
		if(r.equals("-")) an=""+(a-b);
		if(r.equals("*")) an=""+(a*b);
		if(r.equals("/")) an=""+(a/b);
		A.setText(an);
	}
} 