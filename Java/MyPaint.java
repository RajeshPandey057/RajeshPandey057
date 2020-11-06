import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MyPaint extends Applet implements MouseListener, MouseMotionListener, ItemListener {
    Choice col;
    Graphics g;
    int dx, dy;
    int sf = 0, lf = 0, rf = 0;
    CheckboxGroup shape;
    Checkbox line, freehand, circle, rect, es;

    public void init() {
        g = getGraphics();
        col = new Choice();
        col.add("SELECT ANY COLOR");
        col.add("RED");
        col.add("BLUE");
        col.add("GREEN");
        shape = new CheckboxGroup();
        line = new Checkbox("Line", shape, false);
        freehand = new Checkbox("Free Hand", shape, false);
        circle = new Checkbox("Circle", shape, false);
        rect = new Checkbox("Rectangle", shape, false);
        es = new Checkbox("Eraser", shape, false);
        add(line);
        add(freehand);
        add(circle);
        add(rect);
        add(es);
        add(col);
        col.addItemListener(this);
        line.addItemListener(this);
        freehand.addItemListener(this);
        circle.addItemListener(this);
        rect.addItemListener(this);
        es.addItemListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent e) {
        if (sf == 3) {
            int x = e.getX();
            int y = e.getY();
            g.drawOval(x, y, 100, 100);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (sf == 4) {
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
                g.drawRect(dx, dy, w, h);
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
            mySetColor();
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
            mySetColor();
        }
    }

    public void mySetColor() {
        String temp = col.getSelectedItem();
        if (temp.equals("RED")) {
            g.setColor(Color.red);
        } else if (temp.equals("BLUE")) {
            g.setColor(Color.blue);
        } else if (temp.equals("GREEN")) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.black);
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        mySetColor();
        Checkbox temp2 = shape.getSelectedCheckbox();
        if (temp2 == line) {
            sf = 1;
        } else if (temp2 == freehand) {
            sf = 2;
        } else if (temp2 == circle) {
            sf = 3;
        } else if (temp2 == rect) {
            sf = 4;
        } else if (temp2 == es) {
            sf = 5;
        }

    }
}