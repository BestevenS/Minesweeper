package MineSweeperGame.Controller;

import java.awt.Dimension;

import MineSweeperGame.Model.setVarValues;
import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    public Controller(String dif){
        // this.dif = dif;

        setVarValues varValues = new setVarValues(dif);

        gameFrame = new GameFrame(dif);
        gameFrame.setMinimumSize(new Dimension(50 * varValues.getColumns(), 55 * varValues.getRows()));
        gameFrame.setVisible(true);

    }
}
