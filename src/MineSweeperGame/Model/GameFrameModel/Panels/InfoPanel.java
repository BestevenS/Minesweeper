package MineSweeperGame.Model.GameFrameModel.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MineSweeperGame.Model.GameFrameModel.RestartB;

public class InfoPanel extends JPanel {

    private String dif;
    private RestartB restartB;

    private JLabel timerL, minesL, livesL;

    public InfoPanel(String dif){

        this.dif = dif;
        
        initCompo();
    
    }

    private void initCompo(){
        restartB = new RestartB(dif);
    }
}
