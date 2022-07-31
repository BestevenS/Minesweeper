package MineSweeperGame.Model.GameFrameModel.Panels;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import MineSweeperGame.Model.Cell;

public class MainPanel extends JPanel {

    private String dif;

    private GamePanel gPanel;

    private InfoPanel iPanel;

    private Cell[][] cell;

    private int numberOfMines;

    public MainPanel(String dif, Cell[][] cell, int numberOfMines){

        this.cell = cell;

        this.dif = dif;

        this.numberOfMines = numberOfMines;

        initCompo();

    }

    private void initCompo(){

        creator();
        adder();

    }

    private void creator(){

        gPanel = new GamePanel(cell, numberOfMines);
        iPanel = new InfoPanel(dif);

    }

    private void adder(){

        add(iPanel, BorderLayout.NORTH);
        add(gPanel, BorderLayout.SOUTH);

    }

    public JButton getRestartButton(){
        return iPanel.getRestartB();
    }
}
