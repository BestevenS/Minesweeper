package MineSweeperGame.Model.GameFrameModel.Panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private String dif;

    private GamePanel gPanel;

    private InfoPanel iPanel;

    public MainPanel(String dif){
        this.dif = dif;
        initCompo();
    }

    private void initCompo(){
        creator();
        adder();
    }

    private void creator(){
        gPanel = new GamePanel();
        iPanel = new InfoPanel(dif);
    }

    private void adder(){
        add(gPanel, BorderLayout.NORTH);
        add(iPanel, BorderLayout.SOUTH);
    }
}
