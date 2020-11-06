
import java.awt.*;
import java.awt.event.*;

public class mousebrush extends Frame implements MouseMotionListener {
    mousebrush() {

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();
        g.setColor(Color.green);
        g.fillOval(x, y, 15, 15);
    }

    public static void main(String[] arg) {
        new mousebrush();

    }
}
