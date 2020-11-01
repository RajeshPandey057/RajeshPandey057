
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

class form extends JFrame implements ActionListener {
    JLabel j1, j2, l[];
    JTextField t[];
    JProgressBar jb;
    int jbi = 0;
    JTable jt;
    JButton sub, chb, chf;

    form() {
        setVisible(true);
        setSize(400, 600);
        setLayout(new GridLayout(12, 2));
        j1 = new JLabel("Fill up the form Given below:");
        add(j1);
        j2 = new JLabel("");
        add(j2);
        l = new JLabel[10];
        l[0] = new JLabel("FName:");
        l[1] = new JLabel("LName:");
        l[2] = new JLabel("DOB:");
        l[3] = new JLabel("Email:");
        l[4] = new JLabel("PassWord:");
        l[5] = new JLabel("Gender");
        l[6] = new JLabel("Mobile No.:");
        l[7] = new JLabel("Security Question:");
        l[8] = new JLabel("Answer:");
        l[9] = new JLabel("Country:");
        t = new JTextField[10];
        t[0] = new JTextField(15);
        t[1] = new JTextField(15);
        t[2] = new JTextField(15);
        t[3] = new JTextField(15);
        t[4] = new JTextField(15);
        t[5] = new JTextField(15);
        t[6] = new JTextField(15);
        t[7] = new JTextField(15);
        t[8] = new JTextField(15);
        t[9] = new JTextField(15);
        jb = new JProgressBar(0, 100);
        jb.setValue(0);
        jb.setStringPainted(true);
        for (int i = 0; i < 10; i++) {
            add(l[i]);
            add(t[i]);
            t[i].getDocument().addDocumentListener(new DocumentListener() {
                int flag = 0;

                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (flag == 0) {
                        if (jbi < 100) {
                            jbi += 10;
                            flag = 1;
                            jb.setValue(jbi);
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {

                }

                @Override
                public void changedUpdate(DocumentEvent e) {

                }
            });
        }
        sub = new JButton("Submit");
        sub.addActionListener(this);
        add(jb);
        add(sub);
    }

    private void newf() {
        String data[][];
        data = new String[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = l[i].getText();
            data[i][1] = t[i].getText();
        }
        String column[] = { "Attribute", "Value" };
        jt = new JTable(data, column);
        JFrame f1 = new JFrame("Submitted data");
        f1.setLayout(new FlowLayout());
        f1.setVisible(true);
        f1.setSize(300, 350);
        chb = new JButton("Change BG");
        chf = new JButton("Change FG");
        f1.add(chb);
        f1.add(chf);
        JScrollPane sp = new JScrollPane(jt);
        f1.add(sp);
        chb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color def = Color.red;
                Color col = JColorChooser.showDialog(f1, "BackGround Color", def);
                jt.setBackground(col);
            }
        });
        chf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color def = Color.red;
                Color col = JColorChooser.showDialog(f1, "ForGround Color", def);
                jt.setForeground(col);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (jbi == 100) {
            j2.setText("");
            newf();
        } else {
            j2.setText("ERROR:Form is not filled completely");
        }
    }

    public static void main(String[] args) {
        new form();
    }
}
