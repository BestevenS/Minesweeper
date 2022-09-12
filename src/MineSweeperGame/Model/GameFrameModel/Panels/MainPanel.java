package MineSweeperGame.Model.GameFrameModel.Panels;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import MineSweeperGame.Controller.Controller;

public class MainPanel extends JPanel {

    private GamePanel gPanel;

    private InfoPanel iPanel;

    private Controller controller;

    public MainPanel(Controller controller){

        this. controller = controller;

        initCompo();

    }

    private void initCompo(){

        creator();
        adder();

    }

    private void creator(){

        gPanel = new GamePanel(controller);

        iPanel = new InfoPanel(
            controller.getDif(), 
            controller.getNumberOfMines(), 
            controller.getLives()
        );

    }

    private void adder(){

        add(iPanel, BorderLayout.NORTH);
        add(gPanel, BorderLayout.SOUTH);

    }

    public JButton getRestartButton(){
        return iPanel.getRestartB();
    }

    public InfoPanel getInfoPanel(){
        return this.iPanel;
    }

    public GamePanel getGPanel() {
        return gPanel;
    }
}
