package MineSweeperGame.View;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import MineSweeperGame.Model.GameFrameModel.GameFramePanels.MainPanel;

public class GameFrame extends JFrame {

    // private String dif;
    private JMenuBar mb;

    private MainPanel mainPanel;

    public GameFrame(String dif){
        // this.dif = dif;
        setTitle("Minesweeper - " + dif);

        initCompo();

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void initCompo(){
        creator();

        adder();
    }

    private void creator(){
        mb = new JMenuBar();

        mbContent();

        mainPanel = new MainPanel();
    }

    private void adder(){
        add(mb);
        add(mainPanel);
    }

    private void mbContent(){
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Menu().setVisible(true);
            }
        });

        JButton help = new JButton("Help");
        help.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("helpButtonPressed");
            }
        });
    }
}
