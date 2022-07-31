package MineSweeperGame.Controller;

import java.awt.Dimension;

import MineSweeperGame.Model.Cell;
import MineSweeperGame.Model.setVarValues;
import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    private Cell[][] cell;

    private int rows, columns, numberOfMines;

    public Controller(String dif){
        // this.dif = dif;

        setVarValues varValues = new setVarValues(dif);

        this.rows = varValues.getRows();
        this.columns = varValues.getColumns();
        this.numberOfMines = varValues.getNumberOfMines();
        
        this.cell = new Cell[rows][columns];

        gameFrame = new GameFrame(dif, cell, numberOfMines);
        gameFrame.setMinimumSize(new Dimension(100 * varValues.getColumns(), 100 * varValues.getRows()));
        gameFrame.setVisible(true);

    }
}
