package MineSweeperGame.Controller;

import java.awt.event.*;
import java.awt.Dimension;

import MineSweeperGame.Model.Cell;
import MineSweeperGame.Model.setVarValues;
import MineSweeperGame.Model.GameOverDialogs.*;
import MineSweeperGame.View.GameFrame;

public class Controller {

    // private String dif;
    private GameFrame gameFrame;

    //  TODO: change array cell to arraylist

    private Cell[][] cells;

    private int rows, columns, numberOfMines, availableMines, lives, rightCellClicked = 0;

    public Controller(String dif){
        // this.dif = dif;

        setVarValues varValues = new setVarValues(dif);

        this.rows = varValues.getRows();
        this.columns = varValues.getColumns();
        this.availableMines = this.numberOfMines = varValues.getNumberOfMines();
        this.lives = varValues.getLives();

        // createEmptyCellArray();

        this.cells = new Cell[rows][columns];

        gameFrame = new GameFrame(dif, cells, numberOfMines, lives);

        this.cells = gameFrame.getMainPanel().getgPanel().getCell();
        
        cellActionAdder();

        gameFrame.setSize(new Dimension(40 * columns, 52 * rows));
        gameFrame.setVisible(true);

    }

    private void cellActionAdder(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[0].length; j++){

                if(cells[i][j].getContent() == "mined"){
                    cells[i][j].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            minedCellAction();
                        }
                    });
                }

                else {
                    //  TODO: rightCellClicked doesn't count right
                    
                    cells[i][j].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){

                            ++rightCellClicked;
                            System.out.println(rightCellClicked);

                            if(rightCellClicked == ((rows * columns) - numberOfMines)){

                                new Winner().setVisible(true);

                            }
                        }
                    });
                }

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

        else if(lives == 0){
            gameFrame.getMainPanel().getgPanel().setEnabled(false);
            new Loser().setVisible(true);
        }
    }

}

    //  AutoOpen cells if content == "0"
    // private void CellValue0Action(int i, int j){
    //     for(int r = i - 1; r < i + 2; r++){

    //         System.out.println("rows: " + r);

    //         for(int c = j - 1; c < j + 2; c++){
    //             System.out.println("\tcolumns: " + c);
    //             System.out.println("cellvalue0");

    //             if(i == 0 && r == -1){
    //                 r = 0;
    //             }

    //             if(j == 0 && c == -1){
    //                 c = 0;
    //             }

    //             if((r > rows-1) || (c > columns-1))
    //                 continue;

    //             if(cell[r][c].getContent() == "0"){
                    
    //                 CellValue0Action(r, c);
    //                 cell[r][c].cellAction();

    //             }

    //         }

    //     }
    // }