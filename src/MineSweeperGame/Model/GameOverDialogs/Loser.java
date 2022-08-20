package MineSweeperGame.Model.GameOverDialogs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Loser extends JDialog {

    private ArrayList<JLabel> scoresL = new ArrayList<JLabel>();

    private String title;

    private JPanel panel;

    private JLabel scores;

    private JLabel score1;
    private JLabel score2;
    private JLabel score3;
    
    public Loser(){
        initCompo();
    }
    
    private void initCompo(){
        panel = new JPanel(new FlowLayout());
        title = "You win! Fastest MineSweepers!";

        setTitle(title);
        setMinimumSize(new Dimension(400,200));

        scores = new JLabel("Best scores -");
        scoresL.add(scores);

        score1 = new JLabel("Beginner: 10,");
        scoresL.add(score1);

        score2 = new JLabel("Intermediate: 10,");
        scoresL.add(score2);

        score3 = new JLabel("Expert: -");
        scoresL.add(score3);

        for(int i = 0; i < scoresL.size(); i++)
            panel.add(scoresL.get(i));

        add(panel);
    }
}
