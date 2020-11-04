import javax.swing.*;
import java.awt.*;

public class jspinnermain extends JFrame {
    private JLabel l;

    private jspinnermain() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        l = new JLabel("");
        add(l);
        SpinnerModel value = new SpinnerNumberModel(44, 0, 50, 4);
        JSpinner spinner = new JSpinner(value);
        add(spinner);
        spinner.addChangeListener(e -> l.setText("You Have:"));
    }

    public static void main(String[] args) {
        new jspinnermain();
    }
}
