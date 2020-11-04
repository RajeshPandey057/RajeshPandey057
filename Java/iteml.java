
import java.awt.*;
import java.awt.event.*;

public class iteml extends Frame implements ItemListener {
    CheckboxGroup cbg;
    Checkbox c1, c2, c3;

    iteml() {
        setVisible(true);
        setSize(800, 800);
        setLayout(null);
        cbg = new CheckboxGroup();
        c1 = new Checkbox("RED", cbg, false);
        c2 = new Checkbox("BLUE", cbg, false);
        c3 = new Checkbox("GREEN", cbg, false);
        c1.setBounds(50, 20, 40, 40);
        c2.setBounds(90, 20, 40, 40);
        c3.setBounds(130, 20, 40, 40);
        add(c1);
        add(c2);
        add(c3);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent ie) {
        Graphics g = getGraphics();
        Checkbox ct = cbg.getSelectedCheckbox();
        if (ct == c1) {
            g.setColor(Color.red);
            g.fillRect(100, 100, 200, 200);
        } else if (ct == c2) {
            g.setColor(Color.blue);
            g.fillRect(100, 100, 200, 200);
        } else if (ct == c3) {
            g.setColor(Color.green);
            g.fillRect(100, 100, 200, 200);
        }
    }

    public static void main(String[] args)
    {        iteml i=new iteml()	}
}
