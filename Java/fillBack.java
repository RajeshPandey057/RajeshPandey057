import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class fillBack {
    Graphics g;
    JFrame f1;
    JProgressBar pb;

    fillBack() {
        f1 = new JFrame();
        f1.setLayout(new FlowLayout());
        f1.setVisible(true);
        f1.setSize(200, 200);
        pb = new JProgressBar(0, 4);
        pb.setValue(0);
        pb.setStringPainted(true);
        f1.getContentPane().setBackground(Color.red);
        JButton b = new JButton("Change");
        f1.add(b);
        f1.add(pb);
        b.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            g = f1.getGraphics();
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, 100, 100);
            pb.setValue(1);
            Thread.sleep(1500);
            g.fillRect(100, 0, 100, 100);
            pb.setValue(2);
            Thread.sleep(1500);
            g.fillRect(0, 100, 100, 100);
            pb.setValue(3);
            Thread.sleep(1500);
            g.fillRect(100, 100, 100, 100);
            pb.setValue(4);
            Thread.sleep(1500);
        } catch (Exception e1) {
            System.out.println("" + e1);
        }
    }

    public static void main(String[] args) {
        new fillBack();
    }
}
