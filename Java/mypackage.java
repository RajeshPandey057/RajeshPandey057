
package mypackage;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class stackframe extends Frame {
    public stackframe(int[] a, int n, int tos) {
        int i;
        setSize(200, 400);
        setLayout(new GridLayout(tos + 2, 0));
        setVisible(true);
        for (i = tos; i >= 0; i--) {
            Button temp3 = new Button("" + a[i]);
            add(temp3);
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
