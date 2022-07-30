package Game;

import javax.swing.*;

import Game.Player.Loser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JButton implements ActionListener{
    private boolean flagged, open;
    private String content;

    public Cell(){
        this.flagged = false;
        this.open = false;
        this.content = "0";
        imageSetter("closed");
        addActionListener(this);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    rightMouse();
                }
            }
        });
    }

    private void rightMouse(){
        if(this.open == false){
            this.flagged = !flagged;
            
            if(this.flagged == true)
                imageSetter("flagged");
            else
                imageSetter("closed");
        }
    }

    public void imageSetter(String img){
        setIcon(new ImageIcon(getClass().getResource("img/" + img + ".png")));
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getFlagged() {
        return this.flagged;
    }

    
    public void cellAction(){
        this.open = !this.open;
        // setEnabled(false);

        //  showing the content photo of cell
        imageSetter(this.content);

        //  if mined
        if(this.content == "mined"){
            Game.setCurMineNum(Game.getCurMineNum() - 1);   //  mineNum--

            //  updating label of mineNum
            Game.getMineNumLabel().setText("" + Game.getCurMineNum());

            //  if lives == 0
            if(Game.getCurLives() == 0)
                looserFunc();

            //  if lives > 0
            if(Game.getCurLives() > 0){
                //  lives--
                Game.setCurLives(Game.getCurLives() - 1);
                //  updating label of lives
                Game.getLivesLabel().setText("" + Game.getCurLives());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.open && !this.flagged){
            //  if it's closed set it as opened after click
            cellAction();
        }
    }

    private void looserFunc(){
        if(Game.getCurLives() == 0){
            for(int i = 0; i < Game.getGame().getRows(); i++)
                for(int j = 0; j < Game.getGame().getColumns(); j++){
                    if(Game.getCell()[i][j].getContent() == "mined")
                        Game.getCell()[i][j].imageSetter(Game.getCell()[i][j].getContent());
                        Game.getCell()[i][j].setEnabled(false);
                }
        }
        new Loser().setVisible(true);
    }
}