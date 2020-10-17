import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class changetext extends Applet implements ActionListener {
    CheckboxGroup cbg;
    Checkbox c1;
    Checkbox c2;
    Checkbox c3;
    TextField t1;

    public void init() {
        Button sub = new Button("SUBMIT");
        Button res = new Button("RESET");
        t1 = new TextField(20);
        cbg = new CheckboxGroup();
        c1 = new Checkbox("Red", cbg, false);
        c2 = new Checkbox("Green", cbg, false);
        c3 = new Checkbox("Blue", cbg, false);
        add(sub);
        add(res);
        add(t1);
        add(c1);
        add(c2);
        add(c3);
        sub.addActionListener(this);
        res.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String cl = "";
        String b = ae.getActionCommand();
        cl = cbg.getSelectedCheckbox().getLabel();
        if (b.equals("RESET")) {
            t1.setForeground(Color.black);
            cbg.setSelectedCheckbox(null);
        }

        else if (cl.equals("Red")) {
            t1.setForeground(Color.red);
        } else if (cl.equals("Green")) {
            t1.setForeground(Color.green);
        } else if (cl.equals("Blue")) {
            t1.setForeground(Color.blue);
        }
    }
}
