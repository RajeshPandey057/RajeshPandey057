import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class scical extends JFrame implements ActionListener {
    int fact(int n) {
        if (n > 1)
            return n * fact(n - 1);
        else
            return n;
    }

    JButton b1[];
    JTextField t1, t2, t3;

    scical() {
        setVisible(true);
        setSize(275, 400);
        setLayout(new FlowLayout());
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        b1 = new JButton[8];
        b1[0] = new JButton("^");
        b1[1] = new JButton("sin");
        b1[2] = new JButton("cos");
        b1[3] = new JButton("tan");
        b1[4] = new JButton("log10");
        b1[5] = new JButton("!");
        b1[6] = new JButton("P");
        b1[7] = new JButton("C");
        add(t1);
        t1.setText("0");
        for (int i = 0; i <= 7; i++) {
            add(b1[i]);
            b1[i].addActionListener(this);
        }
        add(t2);
        t2.setText("0");
        add(t3);

    }

    public void actionPerformed(ActionEvent e) {
        double ans = 0;
        String s = e.getActionCommand();
        int n1 = Integer.parseInt(t1.getText());
        int n2 = Integer.parseInt(t2.getText());
        switch (s) {
            case "^":
                ans = Math.pow(n1, n2);
                break;
            case "sin":
                ans = Math.sin(n1);
                break;
            case "cos":
                ans = Math.cos(n1);
                break;
            case "tan":
                ans = Math.tan(n1);
                break;
            case "log10":
                ans = Math.log10(n1);
                break;
            case "!":
                ans = fact(n1);
                break;
            case "P":
                ans = (double) fact(n1) / fact(n1 - n2);
                break;
            case "C":
                ans = (double) fact(n1) / (fact(n1 - n2) * fact(n2));
                break;
        }
        t3.setText("=" + ans);
    }

    public static void main(String args[]) {
        new scical();
    }
}
