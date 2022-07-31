package MineSweeperGame.Model;

import javax.swing.*;
import java.awt.event.*;

public class Cell extends JButton {
    
    private boolean flagged, open;

    private String content;

    public Cell(){
        this.flagged = false;
        this.open = false;
        this.content = "0";

        imageSetter("closed");

        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cellAction();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    rightMouse();
                }
            }
        });
    }

    public int cellAction(){

        //  if its open stop
        if(this.open == true){
            System.out.println("opened...");
            return 1;
        }

        //  if its flagged stop
        if(this.flagged == true){
            System.out.println("flagged");
            return 1;
        }

        //  if its closed and not flagged set open = true
        this.open = !this.open;

        //  showing the content photo of cell
        imageSetter(this.content);
        System.out.println(content);
        
        return 0;
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


    //  Content image setting

    public void imageSetter(String img){
        setIcon(new ImageIcon(getClass().getResource("img/" + img + ".png")));
    }


    //  Getters/Setters

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
