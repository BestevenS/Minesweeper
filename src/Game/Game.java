package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Integer.parseInt;
//import java.util.Timer;

public class Game extends JFrame{
    private JMenuBar mb;

    private String smileIcon = "img/smile.png";
//    private Timer timer;

    private int rows;
    private int columns;
    private int numberOfMines;
    private String dif;
    private Cell[][] cells;

    private JPanel mainPanel;
    private JPanel GPanel;
    private JPanel infoPanel;

    private JLabel timerLabel, mineNum, lives;
    private JButton restart, overChecker;

    public Game(String dif){
//        timer = new Timer();
        this.dif = dif;
        setTitle(dif);
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

        Components();

        cells = new Cell[rows][columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                cells[i][j] = new Cell();
                GPanel.add(cells[i][j]);
            }
        }

        indexContent(cells);
    }

    private void indexContent(Cell[][] cells){
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
        int ak;
        for(int a = 0; a<rows; a++){
            for(int k = 0; k<columns; k++){
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
//                    cells[a][k].setIcon(new ImageIcon(getClass().getResource("img/" + ak + ".png")));
                }
            }
        }
    }

    private void visibleMenu(){
        setVisible(false);
        new Menu().setVisible(true);
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
        overChecker = new JButton("Check");
        overChecker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOver();
            }
        });
        restart = new JButton();
        restart.setIcon(new ImageIcon(getClass().getResource(smileIcon)));
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
//                new Game(rows, columns, numberOfMines);
            }
        });
        mineNum = new JLabel(String.valueOf(numberOfMines));
        lives = new JLabel("2");

        infoPanel.add(timerLabel);
        infoPanel.add(restart);
        infoPanel.add(mineNum);
        infoPanel.add(lives);
        infoPanel.add(overChecker);
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
}
