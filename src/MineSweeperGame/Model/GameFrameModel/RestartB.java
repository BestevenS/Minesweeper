package MineSweeperGame.Model.GameFrameModel;

import java.awt.event.*;

import javax.swing.*;

import MineSweeperGame.Controller.Controller;

public class RestartB extends JButton {

    private String dif;

    public RestartB(String dif){

        this.dif = dif;

        String smileIcon = "../img/smile.png";

        setIcon(new ImageIcon(getClass().getResource(smileIcon)));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartAction();
                //  new Game(rows, columns, numberOfMines);
            }
        });
    }

    private void restartAction(){
        new Controller(dif);
    }
}
