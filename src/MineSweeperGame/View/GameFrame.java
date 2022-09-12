package MineSweeperGame.View;

import java.awt.event.*;

import javax.swing.*;

import MineSweeperGame.Controller.Controller;
import MineSweeperGame.Model.GameFrameModel.Panels.MainPanel;

public class GameFrame extends JFrame {
    
    private JMenuBar mb;

    private MainPanel mainPanel;

    private Controller controller;

    public GameFrame(Controller controller){
        
        this.controller = controller;

        setTitle("Minesweeper - " + controller.getDif());

        initCompo();

        // setResizable(false);
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

        mainPanel = new MainPanel(controller);
        mainPanel.getRestartButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
    }

    private void adder(){
        setJMenuBar(mb);

        add(mainPanel);
    }


    //  MenuBar Content
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

        mb.add(newGame);
        mb.add(help);

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
