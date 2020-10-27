import java.awt.*;
import java.awt.event.*;

public class cirmouse extends Frame implements MouseListener {
    cirmouse() {

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        g.setColor(Color.blue);
        g.drawOval(x, y, 25, 25);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public static void main(String[] arg) {
        cirmouse m = new cirmouse();

    }
}
