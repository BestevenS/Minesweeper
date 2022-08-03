package MineSweeperGame.Model.GameFrameModel.Panels;

import javax.swing.JPanel;

import java.awt.*;
import java.util.Random;

import MineSweeperGame.Model.Cell;

public class GamePanel extends JPanel {

    private Cell[][] cell;

    private int rows, columns, numberOfMines;

    public GamePanel(Cell[][] cell, int numberOfMines){
        
        this.cell = cell;

        this.rows = cell.length;

        this.columns = cell[0].length;

        this.numberOfMines = numberOfMines;

        setLayout(new GridLayout(rows, columns));

        initCompo();

    }

    private void initCompo(){
        
        createCells();
        indexContent();
        
    }

    private void indexContent(){

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
            if(cell[rr][rc].getContent() != "mined") {

                cell[rr][rc].setContent("mined");

                i++;
            }
        }
    }

    private void setNonMinedCellContent(){

        //  Double for (rows, columns)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //  if cell is not mined
                if(cell[i][j].getContent() != "mined") {

                    // Searching for Mines around the cell with mineSearcher 
                    // Adding it as cell[i][j].setContent()
                    cell[i][j].setContent((Integer.toString(mineSearcher(i, j))));
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

                if(cell[r][c].getContent() == "mined"){
                    mineCount++;
                }

            }

        }
        return mineCount;
    }

    private void createCells(){
        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[0].length; j++){
                cell[i][j] = new Cell();
                add(cell[i][j]);
            }
        }
    }

    public Cell[][] getCell() {
        return cell;
    }
}