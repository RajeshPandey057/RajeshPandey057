
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class JTreeMain {
    private JTextField t;
    JFrame f1;

    JTreeMain() {
        f1 = new JFrame();
        t = new JTextField(30);
        f1.setVisible(true);
        f1.setLayout(new FlowLayout());
        f1.setSize(400, 400);
        DefaultMutableTreeNode bclcs = new DefaultMutableTreeNode("Color Chooser");
        DefaultMutableTreeNode fclcs = new DefaultMutableTreeNode("Color Chooser");
        DefaultMutableTreeNode bgcl = new DefaultMutableTreeNode("BackGround");
        DefaultMutableTreeNode fgcl = new DefaultMutableTreeNode("ForeGround");
        DefaultMutableTreeNode stl = new DefaultMutableTreeNode("Style");
        bgcl.add(bclcs);
        fgcl.add(fclcs);
        stl.add(bgcl);
        stl.add(fgcl);
        JTree jt = new JTree(stl);
        f1.add(jt);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                if (node == null)
                    return;
                else {
                    if (node == bclcs) {
                        Color def = Color.red;
                        Color cl = JColorChooser.showDialog(f1, "BackGround Color", def);
                        t.setBackground(cl);
                    } else if (node == fclcs) {
                        Color def = Color.red;
                        Color cl = JColorChooser.showDialog(f1, "ForeGround Color", def);
                        t.setForeground(cl);
                    }
                }
            }
        });
        f1.add(t);
    }

    public static void main(String[] args) {
        new JTreeMain();
    }
}
