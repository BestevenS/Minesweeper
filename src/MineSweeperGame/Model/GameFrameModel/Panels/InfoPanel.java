package MineSweeperGame.Model.GameFrameModel.Panels;

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
        timerL = new JLabel("0");
        minesL = new JLabel("10");
        livesL = new JLabel("2");

        add(timerL);
        add(restartB);
        add(minesL);
        add(livesL);
    }

    public RestartB getRestartB() {
        return restartB;
    }
}
