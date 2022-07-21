package Game;

import javax.swing.*;

import Game.Player.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Integer.parseInt;
//import java.util.Timer;

public class Game extends JFrame{

    //  private Timer timer;

    private int rows, columns, numberOfMines;
    private String dif;
    private Cell[][] cells;

    private JPanel mainPanel, gamePanel, infoPanel;

    private JLabel timerLabel, mineNum, lives;

    public Game(String dif){
//        timer = new Timer();
        this.dif = dif;
        setTitle(dif);
        
        //  Set numbers for rows, columns and Mines for every difficulty
        setDiffVars();

        Components();

        //  Initialize all cells
        cellsInitializer();

        indexContent();
    }

    private void indexContent(){
        //  Add random Mines
        randomMinesPositionSetter();
        
        //  Set content of every non-Mine cell
        contentSetterNonMineCells();
        
    }

    private void visibleMenu(){
        setVisible(false);
        new Menu().setVisible(true);
    }

    private void Components(){
        panelCreator();

        menubarCreator();

        addMethod();

        setMinimumSize(new Dimension(50 * columns, 55 * rows));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private void help(){
        new Help().setVisible(true);
    }

    private void addMethod(){
        infoAdd();
        add(mainPanel);
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.SOUTH);
    }

    private void infoAdd(){
        timerLabel = new JLabel("0");
        
        mineNum = new JLabel(String.valueOf(numberOfMines));
        lives = new JLabel("2");

        infoPanel.add(timerLabel);
        infoPanel.add(mineNum);
        infoPanel.add(lives);
    }

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

    private boolean rightCellsMarked(){
        int f = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                if (cells[i][j].isFlagged()) {
                    f++;
                }
            }
        }
        if(numberOfMines == f)
            return true;
        else
            return false;
    }

    private boolean rightCellsOpened(){
        int f = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                System.out.println(cells[i][j].getContent());
                if (!cells[i][j].isFlagged() && !cells[i][j].getIsMine()) {
                    f++;
                    System.out.println(f);
                }
            }
        }
        System.out.println(columns + " * " + rows + " == " + f + " + " + numberOfMines);
        System.out.println((columns * rows) == f + numberOfMines);
        if((columns * rows) == f + numberOfMines)
            return true;
        else return false;
    }

    private void win(){
        new Winner().setVisible(true);
    }

    private void lose(){
        new Loser().setVisible(true);
    }

    public void gameOver(){
        if(rightCellsMarked() || rightCellsOpened()) {
            win();
            System.out.println("you win");
        }
        else if(parseInt(lives.getText())<1) {
            lose();
            System.out.println("you lose");
        }
    }

    private void setDiffVars(){
        //  Set numbers for rows, columns and Mines for every difficulty
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

    private void cellsInitializer(){
        //  Initialize all cells
        cells = new Cell[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j] = new Cell();
                gamePanel.add(cells[i][j]);
            }
        }
    }

    //  Add random Mines
    private void randomMinesPositionSetter(){
        Random rn = new Random();
        int r = rows + 1;
        int c = columns + 1;
        int rr;
        int rc;
        int i = 0;
        while(i<numberOfMines) {
            rr = rn.nextInt(r-1);
            rc = rn.nextInt(c-1);
            if(cells[rr][rc].getIsMine() == false) {
                cells[rr][rc].setIsMine(true);
                cells[rr][rc].setContent("mined");
                i++;
            }
        }
    }


    //  Set content of every non-Mine cell
    private void contentSetterNonMineCells(){
        int ak;
        for(int a = 0; a < rows; a++){
            for(int k = 0; k < columns; k++){
                ak = 0;
                if(cells[a][k].getIsMine() == false) {
                    for(int s = a-1; s<a+2; s++){
                        for(int h = k-1; h<k+2; h++){
                            if(a==0 && s==-1){
                                s=0;
                            }
                            if(k==0 && h==-1){
                                h=0;
                            }
                            if(s>rows-1)
                                continue;
                            if(h>columns-1)
                                continue;
                            if(cells[s][h].getIsMine()){
                                ak++;
                            }
                        }
                    }
                    cells[a][k].setContent((Integer.toString(ak)));
                    //  cells[a][k].setIcon(new ImageIcon(getClass().getResource("img/" + ak + ".png")));
                }
            }
        }
    }

    private void panelCreator(){
        mainPanel = new JPanel(new BorderLayout(2,1));
        infoPanel = new JPanel(new FlowLayout());
        gamePanel = new JPanel(new GridLayout(rows, columns));
    }

    private void menubarCreator(){
        JButton help = new JButton("Help");
        JButton restart = new JButton();
        JButton newGame = new JButton("New Game");

        String smileIcon = "img/smile.png";

        restart.setIcon(new ImageIcon(getClass().getResource(smileIcon)));
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        JMenuBar mb = new JMenuBar();
    
        setJMenuBar(mb);
    
        
        mb.add(newGame);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visibleMenu();
            }
        });

        
        mb.add(help);
        
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });

        infoPanel.add(restart);
    }
}
