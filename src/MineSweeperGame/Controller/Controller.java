package MineSweeperGame.Controller;

import java.awt.event.*;
import java.awt.Dimension;

import MineSweeperGame.Model.Cell;
import MineSweeperGame.Model.setVarValues;
import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    private Cell[][] cell;

    private int rows, columns, numberOfMines, availableMines, lives = 2;

    public Controller(String dif){
        // this.dif = dif;

        setVarValues varValues = new setVarValues(dif);

        this.rows = varValues.getRows();
        this.columns = varValues.getColumns();
        this.availableMines = this.numberOfMines = varValues.getNumberOfMines();
        
        cellActionAdder();

        gameFrame = new GameFrame(dif, cell, numberOfMines);
        gameFrame.setMinimumSize(new Dimension(60 * varValues.getColumns(), 60 * varValues.getRows()));
        gameFrame.setVisible(true);

        this.cell = gameFrame.getMainPanel().getgPanel().getCell();

    }

    private int i, j;

    private void cellActionAdder(){
        for(i = 0; i < rows; i++){
            for(j = 0; i < columns; j++){
                cell[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        cellAction();
                    }
                });
            }
        }
    }

    private void cellAction(){
        if(availableMines > 0 && lives > 0){
            if(cell[i][j].getContent() == "mined"){

                availableMines--;
                gameFrame.getMainPanel().getInfoPanel().setMinesL(availableMines);
                
                lives--;
                gameFrame.getMainPanel().getInfoPanel().setLivesL(lives);

            }
        }
    }
}
