import javax.swing.*;
import java.awt.*;
import java.io.*;

class notepad {
    JTextArea wa;
    JFrame f1;
    String filepath = null;

    private notepad() {
        f1 = new JFrame("NOTEPAD");
        f1.setLayout(new FlowLayout(FlowLayout.LEFT));
        f1.setSize(500, 500);
        f1.setVisible(true);
        JMenuItem open = new JMenuItem("OPEN");
        JMenuItem save = new JMenuItem("SAVE");
        JMenuItem saveAs = new JMenuItem("SAVE AS");
        JMenuItem copy = new JMenuItem("COPY");
        JMenuItem paste = new JMenuItem("PASTE");
        JMenuItem cut = new JMenuItem("CUT");
        JMenuItem helpText = new JMenuItem("HELP TEXT");
        JMenu file = new JMenu("FILE");
        JMenu edit = new JMenu("EDIT");
        JMenu help = new JMenu("HELP");
        file.add(open);
        file.add(save);
        file.add(saveAs);
        edit.add(paste);
        edit.add(copy);
        edit.add(cut);
        help.add(helpText);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        f1.add(menuBar);
        wa = new JTextArea(25, 42);
        JScrollPane js = new JScrollPane(wa);
        f1.add(js);
        helpText.addActionListener(e -> {
            JFrame helpFrame = new JFrame("Help Text");
            JLabel l1 = new JLabel("This is just simple notepad\n" + "You don't need help in using that.");
            helpFrame.setSize(350, 300);
            helpFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
            helpFrame.setVisible(true);
            helpFrame.add(l1);
        });
        copy.addActionListener(e -> wa.copy());
        paste.addActionListener(e -> wa.paste());
        cut.addActionListener(e -> wa.cut());
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(f1);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                filepath = f.getPath();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String s1 = "", s2 = "";
                    while ((s1 = br.readLine()) != null) {
                        s2 += s1 + "\n";
                    }
                    wa.setText(s2);
                    br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        save.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter(filepath);
                fw.write(wa.getText());
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        saveAs.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(f1, "Name Of Your File:", null);
            File f = new File(name);
            try {
                if (f.createNewFile()) {
                    try {
                        FileWriter fw = new FileWriter(name);
                        fw.write(wa.getText());
                        fw.close();
                        JOptionPane.showMessageDialog(f1, "The File has been created SUCCESSFULLY!");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
    }

    public static void main(String[] args) {
        new notepad();
    }
}
