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

        // createEmptyCellArray();

        this.cell = new Cell[rows][columns];

        gameFrame = new GameFrame(dif, cell, numberOfMines, lives);

        this.cell = gameFrame.getMainPanel().getgPanel().getCell();
        
        cellActionAdder();

        gameFrame.setMinimumSize(new Dimension(60 * varValues.getColumns(), 60 * varValues.getRows()));
        gameFrame.setVisible(true);

    }

    private void cellAction(){
        System.out.println("cellAction controller");
        this.availableMines = gameFrame.getMainPanel().getgPanel().getNumberOfMines();
        gameFrame.getMainPanel().getInfoPanel().setMinesL(availableMines);
        
        this.lives = gameFrame.getMainPanel().getgPanel().getLives();
        gameFrame.getMainPanel().getInfoPanel().setLivesL(lives);

    }

    private void cellActionAdder(){

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                // cell[i][j] = gameFrame.getMainPanel().getgPanel().getCell()[i][j];

                cell[i][j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        cellAction();
                    }
                });

            }
        }

    }


    // private void createEmptyCellArray(){
    //     for(int i = 0; i < rows; i++){
    //         for(int j = 0; j < columns; j++){
    //             cell[i][j] = new Cell();
    //             System.out.println(cell.length);
    //         }
    //     }
    // }
}
