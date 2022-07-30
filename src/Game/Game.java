package Game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//import java.util.Timer;

public class Game extends JFrame{
    private JMenuBar mb;

    private String smileIcon = "img/smile.png";
    //  private Timer timer;

    private int rows, columns, numberOfMines;//timer;

    //  allMyStatics
    private static Game game;

    private static int curMineNum = 0, curLives = 2;

    private String dif;

    private static Cell[][] cell;

    private JPanel mainPanel, GPanel, infoPanel;

    private JLabel timerLabel;

    private static JLabel mineNumLabel, livesLabel;

    private JButton restart;

    public Game(String dif){
    //  timer = new Timer();
        this.dif = dif;
        
        setTitle(dif);

        //  Setting the number of rows, columns and Mines
        setDif();

        Components();

        //  Create and add cells in GPanel
        cellsCreatorAdd();

        indexContent();
    }

    private void Components(){
        mainPanel = new JPanel(new BorderLayout(2,1));
        infoPanel = new JPanel(new FlowLayout());
        GPanel = new JPanel(new GridLayout(rows, columns));
        mb = new JMenuBar();
        setJMenuBar(mb);
        JButton newGame = new JButton("New Game");
        mb.add(newGame);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visibleMenu();
            }
        });

        JButton help = new JButton("Help");
        mb.add(help);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });

        addMethod();

        setMinimumSize(new Dimension(50 * columns, 55 * rows));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private void indexContent(){
        setMinesPlaces();
        setNonMinedCellContent();
    }

    private void visibleMenu(){
        setVisible(false);
        new Menu().setVisible(true);
    }

    private void help(){
        new Help().setVisible(true);
    }

    private void addMethod(){
        infoAdd();
        add(mainPanel);
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(GPanel, BorderLayout.SOUTH);
    }

    private void infoAdd(){
        timerLabel = new JLabel("0");
        
        restart = new JButton();
        restart.setIcon(new ImageIcon(getClass().getResource(smileIcon)));
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
                //  new Game(rows, columns, numberOfMines);
            }
        });

        Game.curMineNum = numberOfMines;

        mineNumLabel = new JLabel(String.valueOf(Game.curMineNum));

        livesLabel = new JLabel(String.valueOf(Game.curLives));

        infoPanel.add(timerLabel);
        infoPanel.add(restart);
        infoPanel.add(mineNumLabel);
        infoPanel.add(livesLabel);
    }

    // private boolean rightCellsMarked(){
    //     int f = 0;
    //     for(int i = 0; i<rows; i++){
    //         for(int j = 0; j<columns; j++){
    //             if (cell[i][j].getFlagged()) {
    //                 f++;
    //             }
    //         }
    //     }

    //     if(numberOfMines == f)
    //         return true;
    //     else
    //         return false;
    // }

    // private boolean rightCellsOpened(){
    //     int f = 0;
    //     for(int i = 0; i<rows; i++){
    //         for(int j = 0; j<columns; j++){
    //             System.out.println(cell[i][j].getContent());
    //             if (!cell[i][j].getFlagged() && cell[i][j].getContent() != "mined") {
    //                 f++;
    //                 System.out.println(f);
    //             }
    //         }
    //     }
    //     System.out.println(columns + " * " + rows + " == " + f + " + " + numberOfMines);
    //     System.out.println((columns * rows) == f + numberOfMines);
    //     if((columns * rows) == f + numberOfMines)
    //         return true;
    //     else return false;
    // }

    // private void win(){
    //     new Winner().setVisible(true);
    // }

    // private void lose(){
    //     new Loser().setVisible(true);
    // }

    public void gameOver(){
        System.out.println("You loose!");
    }

    private void setDif(){
        if(this.dif == "beginner") {
            this.rows = 9;
            this.columns = 9;
            this.numberOfMines = 10;
        }

        else if(this.dif == "intermediate") {
            this.rows = 16;
            this.columns = 16;
            this.numberOfMines = 30;
        }

        else if(this.dif == "expert") {
            this.rows = 16;
            this.columns = 30;
            this.numberOfMines = 50;
        }
    }

    private void cellsCreatorAdd(){
        cell = new Cell[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cell[i][j] = new Cell();
                // System.out.println(Game.getGame());
                // System.out.println("Number of available Mines ->" + Menu.getTheGame().curMineNum);
                // cell[i][j].addActionListener(new ActionListener(){
                //     @Override
                //     public void actionPerformed(ActionEvent e) {
                //         cellAction();
                //     }
                // });

                GPanel.add(cell[i][j]);
            }
        }
    }

    private void setMinesPlaces(){
        
        Random rn = new Random();
        
        //  random row, random column
        int rr, rc;

        int i = 0;

        while(i < numberOfMines) {
            rr = rn.nextInt(rows);
            rc = rn.nextInt(columns);

            //  If content not mined then set content as mined
            if(cell[rr][rc].getContent() != "mined") {
                cell[rr][rc].setContent("mined");
                
                cell[rr][rc].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        looserFunc();
                    }
                });

                i++;
            }
        }
    }

    private void looserFunc(){
        
    }

    private void setNonMinedCellContent(){

        //  Double for (rows, columns)
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //  if cell is not mined
                if(cell[i][j].getContent() != "mined") {

                    //  Searching for Mines around the cell with mineSearcher 
                    //  Adding it as cell[i][j].setContent()
                    cell[i][j].setContent((Integer.toString(mineSearcher(i, j))));
                    //  cells[a][k].setIcon(new ImageIcon(getClass().getResource("img/" + ak + ".png")));
                }
            }
        }
        // printskonaki();
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

    // private void printskonaki(){
    //     for(int i = 0; i < rows; i++){
    //         for(int j = 0; j < columns; j++){
    //             System.out.print(cell[i][j].getContent() + "\t ");
    //         }
    //         System.out.println();
    //     }
    // }

    // static Getters/Setters

    private void newGame(){
        setVisible(false);
        new Game(this.dif).setVisible(true);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public static int getCurLives() {
        return curLives;
    }

    public static void setCurLives(int curLives) {
        Game.curLives = curLives;
    }

    public static int getCurMineNum() {
        return curMineNum;
    }

    public static void setCurMineNum(int curMineNum) {
        Game.curMineNum = curMineNum;
    }

    public static Game getGame(){
        return Game.game;
    }

    public static void setGame(Game game){
        Game.game = game;
    }

    public static JLabel getMineNumLabel() {
        return Game.mineNumLabel;
    }

    public static JLabel getLivesLabel() {
        return Game.livesLabel;
    }

    public static Cell[][] getCell() {
        return Game.cell;
    }
}