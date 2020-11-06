
import java.awt.*;
import java.awt.event.*;

public class mousemotion extends Frame implements MouseMotionListener {
    String s1 = "Location ";
    Label l1;

    mousemotion() {
        l1 = new Label("");
        setSize(400, 400);
        setLayout(null);
        l1.setBounds(100, 100, 10000, 100);
        add(l1);
        setVisible(true);
        addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        l1.setText(s1 + "X:" + x + "Y:" + y + "Mouse moved");
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        l1.setText(s1 + "X:" + x + "Y:" + y + "Mouse Draged");
    }

    public static void main(String[] arg) {
        new mousemotion();
    }
}
