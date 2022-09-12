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

    private int rows, columns, numberOfMines, availableMines, 
                lives, rightCellClicked = 0;

    private String dif;

    public Controller(String dif){
        this.dif = dif;

        new setVarValues(this);

        // createEmptyCellArray();

        this.cells = new Cell[rows][columns];

        gameFrame = new GameFrame(this);

        // this.cells = gameFrame.getMainPanel().getgPanel().getCell();

        gameFrame.setSize(new Dimension(40 * columns, 52 * rows));
        gameFrame.setVisible(true);

    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getAvailableMines() {
        return availableMines;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getLives() {
        return lives;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public String getDif() {
        return dif;
    }

    public int getRightCellClicked() {
        return rightCellClicked;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }


    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRightCellClicked(int rightCellClicked) {
        this.rightCellClicked = rightCellClicked;
    }

    public void setAvailableMines(int availableMines) {
        this.availableMines = availableMines;
    }
}