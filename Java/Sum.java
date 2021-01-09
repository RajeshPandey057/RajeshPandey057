import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class sum extends Applet implements ActionListener {
    Label l1;
    TextField t1, t2;

    public void init()
{
	t1=new TextField(20);
	t2=new TextField(20);
	l1=new Label(“”);
	add(t1);
	add(t2);
	add(l1);
	t2.addActionListener(this);
	}

    public void actionPerformed(ActionEvent e)
	{
		l3.setText(“sum is:” + (Integer.parseInt(t1.getText)+ Integer.parseInt(t2.getText)));
	}
}
