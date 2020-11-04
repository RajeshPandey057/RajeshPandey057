import javax.swing.*;
import java.awt.*;

public class jslidemain extends JFrame {
    private JLabel l;

    private jslidemain() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        l = new JLabel("");
        add(l);
        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 10);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        add(slider);
        slider.addChangeListener(e -> l.setText("You are at Value:" + slider.getValue()));
    }

    public static void main(String[] args) {
        new jslidemain();
    }
}
