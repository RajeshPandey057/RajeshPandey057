import java.awt.*;
import java.awt.event.*;

public class illmouse extends Frame implements MouseListener {
    illmouse() {
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        String s = "Mouse loaction X:" + x + "Y:" + y + "Mouse Pressed";
        g.setColor(Color.blue);
        g.drawString(s, 100, 100);
    }

    public void mouseReleased(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        String s = "Mouse loaction X:" + x + "Y:" + y + "Mouse Released";
        g.setColor(Color.blue);
        g.drawString(s, 100, 100);
    }

    public void mouseEntered(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        String s = "Mouse loaction X:" + x + "Y:" + y + "Mouse Entered";
        g.setColor(Color.blue);
        g.drawString(s, 100, 100);
    }

    public void mouseExited(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        String s = "Mouse loaction X:" + x + "Y:" + y + "Mouse Exited";
        g.setColor(Color.blue);
        g.drawString(s, 100, 100);
    }

    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        String s = "Mouse loaction X:" + x + "Y:" + y + "Mouse Clicked";
        g.setColor(Color.blue);
        g.drawString(s, 100, 100);
    }

    public static void main(String[] arg) {
        new illmouse();
    }
}
