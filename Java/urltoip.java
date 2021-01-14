import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class urltoip extends Applet implements ActionListener {
    TextField t1;
    Label l1;

    public void init() {
        Button sub = new Button("SHOWIP");
        t1 = new TextField(40);
        l1 = new Label("");
        add(t1);
        add(sub);
        add(l1);
        sub.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String host = t1.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            l1.setText(ip);
        } catch (Exception e) {

        }
    }
}
