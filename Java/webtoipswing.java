
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.UnknownHostException;

public class webtoipswing extends JFrame implements ActionListener {
    private JLabel l;
    private JTextField t;

    private webtoipswing() {
        setLayout(new FlowLayout());
        setSize(300, 400);
        setVisible(true);
        t = new JTextField(25);
        JButton con = new JButton("SHOW IP");
        l = new JLabel("");
        add(t);
        add(con);
        add(l);
        con.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            l.setText(
                    "IP of :" + t.getText() + " is:\n " + java.net.InetAddress.getByName(t.getText()).getHostAddress());
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new webtoipswing();
    }
}
