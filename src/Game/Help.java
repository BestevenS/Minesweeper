package Game;

import javax.swing.*;
import java.awt.*;

public class Help extends JDialog {
    private String title;

    private JPanel panel;

    private JLabel creator;

    public Help() {
        initCompo();
    }

    private void initCompo() {
        panel = new JPanel(new FlowLayout());
        title = "Help";
        setTitle(title);
        setMinimumSize(new Dimension(400, 200));
        creator = new JLabel("Creator: Stefanos Chidiroglou \nAm: tp4916");
        panel.add(creator);
        add(panel);
    }
} 