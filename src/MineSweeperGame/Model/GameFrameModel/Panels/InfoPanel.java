package MineSweeperGame.Model.GameFrameModel.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MineSweeperGame.Model.GameFrameModel.RestartB;

public class InfoPanel extends JPanel {

    private String dif;
    private int numberOfMines, lives;
    private RestartB restartB;

    private JLabel timerL, minesL, livesL;

    public InfoPanel(String dif, int numberOfMines, int lives){

        this.dif = dif;

        this.numberOfMines = numberOfMines;

        this.lives = lives;
        
        initCompo();
    
    }

    private void initCompo(){
        restartB = new RestartB(dif);
        timerL = new JLabel("0");
        minesL = new JLabel("" + numberOfMines);
        livesL = new JLabel("" + lives);

        add(timerL);
        add(restartB);
        add(minesL);
        add(livesL);
    }

    public RestartB getRestartB() {
        return restartB;
    }


    //  Getters/Setters

    // public JLabel getTimerL() {
    //     return timerL;
    // }

    // public void setTimerL(JLabel timerL) {
    //     this.timerL = timerL;
    // }

    public JLabel getMinesL() {
        return minesL;
    }

    public void setMinesL(int x) {
        minesL.setText("" + x);
    }

    public JLabel getLivesL() {
        return livesL;
    }

    public void setLivesL(int x) {
        livesL.setText("" + x);
    }
}
