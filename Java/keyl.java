
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class keyl extends Applet implements KeyListener {
    String msg = "";

    public void init() {
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent k) {

    }

    public void keyPressed(KeyEvent k) {
        char s = k.getKeyChar();
        showStatus("You have Pressed " + s);
    }

    public void keyTyped(KeyEvent k) {
        char c = k.getKeyChar();
        msg = "";
        msg = msg + c;
        if (msg.equals("a")) {
            msg = msg + " for APPLET";
        } else if (msg.equals("e")) {
            msg = msg + " for ELEPHANT";
        } else if (msg.equals("i")) {
            msg = msg + " for INTERNET";
        } else if (msg.equals("o")) {
            msg = msg + " for ORACLE";
        } else if (msg.equals("u")) {
            msg = msg + " for UMBRELLA";
        } else {
            msg = "Press vowels only";
        }
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 100, 100);
    }
}
