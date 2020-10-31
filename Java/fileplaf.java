import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

class fileplaf {
    JFrame f1;

    fileplaf() {
        f1 = new JFrame();
        f1.setVisible(true);
        f1.setLayout(new FlowLayout());
        f1.setSize(400, 400);
        JButton b1 = new JButton("Change LAF");
        f1.add(b1);
        b1.addActionListener(e -> {
            try {
                Scanner sc = new Scanner(new File("input.txt"));
                String s = sc.nextLine();
                if (s.equals("metal")) {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(f1);
                } else if (s.equals("motif")) {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(f1);
                } else if (s.equals("window")) {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(f1);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    public static void main(String[] atgs) {
        new fileplaf();
    }
}
