package MineSweeperGame.Model.GameFrameModel.Panels;

import javax.swing.JPanel;

import java.awt.*;
import java.util.Random;

import MineSweeperGame.Controller.Controller;
import MineSweeperGame.Model.Cell;

public class GamePanel extends JPanel {

    private Cell[][] cells;

    private int rows, columns, numberOfMines, lives;

    private Controller controller;

    public GamePanel(Controller controller){
    
        this.controller = controller;

        this.cells = controller.getCells();
        
        this.rows = controller.getRows();

        this.columns = controller.getColumns();

        this.numberOfMines = controller.getNumberOfMines();

        this.lives = controller.getLives();

        setLayout(new GridLayout(rows, columns));

        initCompo();

    }

    private void initCompo(){
        
        createCells();
        indexCellContent();
        
    }

    //  About Cells
    
    private void indexCellContent(){

        setMinesPlaces();
        setNonMinedCellContent();
            
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
            if(cells[rr][rc].getContent() != "mined") {

                cells[rr][rc].setContent("mined");

                i++;

            }
        }
    }

    public void setNonMinedCellContent(){

        int x = 0;

        //  Double for (rows, columns)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //  if cell is not mined
                if(cells[i][j].getContent() != "mined") {

                    // Searching for Mines around the cell with mineSearcher 
                    // Adding it as cell[i][j].setContent()

                    x = mineSearcher(i, j);

                    cells[i][j].setContent((Integer.toString(x)));
                    
                    // cell[i][j].imageSetter(cell[i][j].getContent());
                    // cells[a][k].setIcon(new ImageIcon(getClass().getResource("img/" + ak + ".png")));

                }
            }
        }
    }

    private int mineSearcher(int i, int j){

        int mineCount = 0;  //  Var counts Mines around

        for(int r = i - 1; r < i + 2; r++){

            for(int c = j - 1; c < j + 2; c++){

                if(i == 0 && r == -1){
                    r = 0;
                }

                if(j == 0 && c == -1){
                    c = 0;
                }

                if((r > rows-1) || (c > columns-1))
                    continue;

                if(cells[r][c].getContent() == "mined"){
                    mineCount++;
                }

            }

        }

        return mineCount;
    }

    private void createCells(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[0].length; j++){
                cells[i][j] = new Cell(controller);
                add(cells[i][j]);
            }
        }
    }

    //  Getters
    public Cell[][] getCell() {
        return this.cells;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public int getLives() {
        return lives;
    }
}