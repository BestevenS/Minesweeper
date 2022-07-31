package MineSweeperGame.Controller;

import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    public Controller(String dif){
        // this.dif = dif;

        gameFrame = new GameFrame(dif);
        gameFrame.setVisible(true);

    }
}
