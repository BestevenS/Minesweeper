package MineSweeperGame.Controller.MenuButtons;

import java.awt.event.*;
import javax.swing.*;

import MineSweeperGame.Controller.Controller;

public abstract class MenuButton extends JButton {

    public MenuButton(String dif){
        setText(dif);

        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Controller(dif);
            }
        });
    }
    
}
