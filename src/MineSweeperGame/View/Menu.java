package MineSweeperGame.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MineSweeperGame.Controller.MenuButtons.*;
import MineSweeperGame.Controller.MenuButtons.subButtons.beginnerButton;
import MineSweeperGame.Controller.MenuButtons.subButtons.expertButton;
import MineSweeperGame.Controller.MenuButtons.subButtons.intermediateButton;

public class Menu extends JFrame {
    public Menu(){

        setTitle("Difficulties");

        initComponents();

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    private void initComponents(){
        creatorMethod();
        addMethod();
    }


    private void creatorMethod(){

        mainPanel = new JPanel();

        difficulties = new JLabel("Difficulties: ");

        beginner = new beginnerButton();
        intermediate = new intermediateButton();
        expert = new expertButton();

        buttonActions();
    }

    private void addMethod(){
        mainPanel.add(difficulties);
        mainPanel.add(beginner);
        mainPanel.add(intermediate);
        mainPanel.add(expert);
        add(mainPanel);
    }

    private void buttonActions(){
        beginner.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                settingMenuInvisible();                
            }
        });

        intermediate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                settingMenuInvisible();                
            }
        });

        expert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                settingMenuInvisible();                
            }
        });
    }

    private void settingMenuInvisible(){
        setVisible(false);
    }


    //  Variables
    private JLabel difficulties;
    private JPanel mainPanel;
    private beginnerButton beginner; 
    private intermediateButton intermediate;
    private expertButton expert;
}
