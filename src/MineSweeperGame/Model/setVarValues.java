package MineSweeperGame.Model;

public class setVarValues {

    private int rows, columns, numberOfMines, lives;

    public setVarValues(String dif){
        if(dif == "Beginner"){
            this.rows = 9;
            this.columns = 9;
            this.numberOfMines = 10;
            this.lives = 3;
        }
        else if(dif == "Intermediate"){
            this.rows = 16;
            this.columns = 16;
            this.numberOfMines = 30;
            this.lives = 2;
        }
        else {  //  expert button option
            this.rows = 16;
            this.columns = 30;
            this.numberOfMines = 50;
            this.lives = 1;
        }
    }

    // Getters/Setters

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getNumberOfMines() {
        return this.numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public int getLives() {
        return lives;
    }
}
