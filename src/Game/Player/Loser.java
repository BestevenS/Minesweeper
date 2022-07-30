package Game.Player;

import javax.swing.*;
import java.awt.*;

public class Loser extends JDialog {
    private String title;

    private JPanel panel;

    private JLabel explain;
    private JLabel score1;
    private JLabel score2;
    private JLabel score3;

    public Loser() {
        initCompo();
    }

    private void initCompo() {
        panel = new JPanel(new FlowLayout());
        title = "You lose\nFastest MineSweepers!";
        setTitle(title);
        setMinimumSize(new Dimension(400, 200));
        explain = new JLabel("Best scores -");
        panel.add(explain);
        score1 = new JLabel("Beginner: 10,");
        panel.add(score1);
        score2 = new JLabel("Intermediate: 10,");
        panel.add(score2);
        score3 = new JLabel("Expert: -");
        panel.add(score3);
        add(panel);
    }
} 