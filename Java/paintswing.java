
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paintSwing implements MouseListener, MouseMotionListener {
    Graphics g;
    JFrame f1;
    Color col;
    int sf = 0, lf = 0, rf = 0;
    int dx, dy;

    paintSwing() {
        f1 = new JFrame();
        f1.setSize(400, 400);
        f1.setVisible(true);
        f1.setLayout(new FlowLayout());
        g = f1.getGraphics();
        JMenuItem fh = new JMenuItem("FREE HAND");
        JMenuItem cr = new JMenuItem("CIRCLE");
        JMenuItem rc = new JMenuItem("RECTANGLE");
        JMenuItem ln = new JMenuItem("LINE");
        JMenuItem fcr = new JMenuItem("FILL CIRCLE");
        JMenuItem frc = new JMenuItem("FILL RECTANGLE");
        JMenuItem er = new JMenuItem("ERASER");
        JMenuItem colp = new JMenuItem("PICK COLOR");
        JMenu jm = new JMenu("Paint");
        jm.add(ln);
        jm.add(rc);
        jm.add(cr);
        jm.add(fcr);
        jm.add(frc);
        jm.add(fh);
        jm.add(er);
        jm.add(colp);
        JMenuBar jmb = new JMenuBar();
        jmb.add(jm);
        f1.add(jmb);
        f1.addMouseListener(this);
        f1.addMouseMotionListener(this);
        fh.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 2;
            }
        });
        cr.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 3;
            }
        });
        rc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 4;
            }
        });
        ln.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 1;
            }
        });
        er.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 5;
            }
        });
        fcr.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 6;
            }
        });
        frc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sf = 7;
            }
        });
        colp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Color def = Color.red;
                col = JColorChooser.showDialog(f1, "Choose Color", def);
                JOptionPane.showMessageDialog(f1, "You have selected COLOR: " + col);
                g.setColor(col);
            }
        });

    }

    public void mousePressed(MouseEvent e) {
        if (sf == 3) {
            int x = e.getX();
            int y = e.getY();
            g.drawOval(x, y, 100, 100);
        } else if (sf == 6) {
            int x = e.getX();
            int y = e.getY();
            g.fillOval(x, y, 100, 100);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (sf == 4 | sf == 7) {
            int x = e.getX();
            int y = e.getY();
            if (rf == 0) {
                dx = x;
                dy = y;
                rf = 1;
            } else {
                int h, w;
                w = Math.abs(dx - x);
                h = Math.abs(dy - y);
                if (sf == 4)
                    g.drawRect(dx, dy, w, h);
                else
                    g.fillRect(dx, dy, w, h);
                rf = 0;
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (sf == 1) {
            int x = e.getX();
            int y = e.getY();
            if (lf == 0) {
                dx = x;
                dy = y;
                lf = 1;
            } else {
                g.drawLine(x, y, dx, dy);
                lf = 0;
            }
        } else if (sf == 5) {
            int x = e.getX();
            int y = e.getY();
            g.setColor(Color.white);
            g.fillRect(x - 12, y - 12, 25, 25);
            g.setColor(col);
        } else if (sf == 2) {
            int x = e.getX();
            int y = e.getY();
            g.fillOval(x, y, 15, 15);
        }
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if (sf == 2) {
            int x = e.getX();
            int y = e.getY();
            g.fillOval(x, y, 15, 15);
        }
        if (sf == 5) {
            int x = e.getX();
            int y = e.getY();
            g.setColor(Color.white);
            g.fillRect(x - 12, y - 12, 25, 25);
            g.setColor(col);
        }
    }

    public static void main(String[] args) {
        new paintSwing();
    }
}
