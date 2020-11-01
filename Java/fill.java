import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*

*/
public class fill implements ItemListener
{
	CheckboxGroup cg;
	Checkbox c1,c2,c3;
	Frame f1;
	fill()
	{
		f1=new Frame();
		f1.setLayout(null);
		f1.setSize(400,400);
		f1.setVisible(true);
		cg=new CheckboxGroup();
		c1=new Checkbox("Red",cg,false);
		c2=new Checkbox("Green",cg,false);
		c3=new Checkbox("Blue",cg,false);
		c1.setBounds(50,250,100,30);
		c2.setBounds(150,250,100,30);
		c3.setBounds(250,250,100,30);
		f1.add(c1);
		f1.add(c2);
		f1.add(c3);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e)
	{
		Graphics g=f1.getGraphics();
		Checkbox temp=cg.getSelectedCheckbox();
		if(temp==c1)
		{
			g.setColor(Color.red);
			g.fillRect(50,50,100,100);
		}
		if(temp==c3)
		{
			g.setColor(Color.blue);
			g.fillRect(50,50,100,100);
		}
		if(temp==c2)
		{
			g.setColor(Color.green);
			g.fillRect(50,50,100,100);
		}
	}
	public static void main(String []args)
	{
		fill  f2=new fill();
		
	}

}

