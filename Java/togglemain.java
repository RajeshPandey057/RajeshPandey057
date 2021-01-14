import javax.swing.*;
import java.awt.*;

public class toggleMain extends JFrame {
    private toggleMain() {
        getContentPane().setBackground(Color.black);
        setLayout(new FlowLayout());
        setSize(400, 400);
        setVisible(true);
        JToggleButton button = new JToggleButton("BULB:ON");
        add(button);
        button.addItemListener(e -> {
            if (button.getText().equals("BULB:ON")) {
                getContentPane().setBackground(Color.WHITE);
                button.setText("BULB:OFF");
            } else {
                getContentPane().setBackground(Color.BLACK);
                button.setText("BULB:ON");
            }
        });
    }

    public static void main(String[] args) {
        new toggleMain();
    }
}
