package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JButton implements ActionListener{
    private boolean isMine, flagged;
    private String content;

    public Cell(){
        this.flagged = false;
        this.isMine = false;
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
        this.flagged = !flagged;
        if(this.flagged == true)
            imageSetter("flagged");
        else
            imageSetter("closed");
    }

    public void imageSetter(String img){
        setIcon(new ImageIcon(getClass().getResource("img/" + img + ".png")));
    }

    public boolean getIsMine() {
        return isMine;
    }

    public void setIsMine(boolean mine) {
        this.isMine = mine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cellOpen();
    }

    public void cellOpen(){
        imageSetter(this.content);
//        setEnabled(false);
    }
}
