import java.awt.*;
        import java.applet.*;
        import java.awt.event.*;
/*<applet code="key.class" width="500" height="500"></applet>*/
public class key extends Applet implements KeyListener
{
    String s1,s2;
    public void init()
    {
        s1=new String();

        addKeyListener(this);
    }
    public void keyPressed(KeyEvent k)
    {
        s2=new String();
        s2=""+k.getKeyChar();
        showStatus("You pressed "+s2);
    }
    public void keyReleased(KeyEvent k)
    {

    }
    public void keyTyped(KeyEvent k)
    {
        s1=""+k.getKeyChar();
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(s1, 40, 20);
    }
}
