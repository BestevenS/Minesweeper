package MineSweeperGame.Controller;

import java.awt.event.*;
import java.util.Random;
import java.awt.Dimension;

import MineSweeperGame.Model.Cell;
import MineSweeperGame.Model.setVarValues;
import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    private Cell[][] cell;

    private int rows, columns, numberOfMines, availableMines, lives;

    public Controller(String dif){
        // this.dif = dif;

        setVarValues varValues = new setVarValues(dif);

        this.rows = varValues.getRows();
        this.columns = varValues.getColumns();
        this.availableMines = this.numberOfMines = varValues.getNumberOfMines();
        this.lives = varValues.getLives();

        // createEmptyCellArray();

        this.cell = new Cell[rows][columns];

        gameFrame = new GameFrame(dif, cell, numberOfMines, lives);

        this.cell = gameFrame.getMainPanel().getgPanel().getCell();

        indexCellContent();
        
        // cellActionAdder();

        gameFrame.setMinimumSize(new Dimension(60 * varValues.getColumns(), 60 * varValues.getRows()));
        gameFrame.setVisible(true);

    }

    private void indexCellContent(){

        setMinesPlaces();
        gameFrame.getMainPanel().getgPanel().setNonMinedCellContent();
            
    }

    private void setMinesPlaces(){
        
        Random rn = new Random();
        
        //  random row, random column
        
        int i = 0;

        while(i < numberOfMines) {
            int rr, rc;
            rr = rn.nextInt(rows);
            rc = rn.nextInt(columns);

            //  If content not mined then set content as mined
            if(cell[rr][rc].getContent() != "mined") {

                cell[rr][rc].setContent("mined");

                cell[rr][rc].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        minedCellAction();
                    }
                });
                i++;
            }
        }
    }

    private void minedCellAction(){
        if(availableMines > 0 && lives > 0){

            --availableMines;
            --lives;
            
            gameFrame.getMainPanel().getInfoPanel().setMinesL(availableMines);
            
            gameFrame.getMainPanel().getInfoPanel().setLivesL(lives);

        }        
    }

    // private void cellActionAdder(){

    //     for(int i = 0; i < rows; i++){
    //         for(int j = 0; j < columns; j++){
    //             // cell[i][j] = gameFrame.getMainPanel().getgPanel().getCell()[i][j];

    //             cell[i][j].addActionListener(new ActionListener(){
    //                 @Override
    //                 public void actionPerformed(ActionEvent e){
    //                     cellAction();
    //                 }
    //             });

    //         }
    //     }

    // }
}
