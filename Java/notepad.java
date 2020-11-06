import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class notepad extends Applet implements KeyListener {
    String msg = "";
    String msg2 = "";
    int x = 100;

    static public String backspace(String str) {
        return str.substring(0, str.length() - 1);
    }

    public void init() {
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent k) {
    }

    public void keyPressed(KeyEvent k) {
    }

    public void keyTyped(KeyEvent k) {
        char c = k.getKeyChar();
        if (c == '\b') {
            msg = backspace(msg);
        } else if (c == '\n') {
            msg2 = msg;
            msg = "";
        } else {
            msg = msg + c;
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg2, 100, x);
        g.drawString(msg, 100, x + 20);
    }
}
