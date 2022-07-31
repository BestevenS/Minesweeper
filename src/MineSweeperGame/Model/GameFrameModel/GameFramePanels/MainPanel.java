package MineSweeperGame.Model.GameFrameModel.GameFramePanels;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private GamePanel gPanel;

    private InfoPanel iPanel;

    public MainPanel(){
        initCompo();
    }

    private void initCompo(){
        creator();
        adder();
    }

    private void creator(){
        gPanel = new GamePanel();
        iPanel = new InfoPanel();
    }

    private void adder(){
        add(gPanel);
        add(iPanel);
    }
}
