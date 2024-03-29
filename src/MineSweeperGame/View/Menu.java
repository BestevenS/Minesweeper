package MineSweeperGame.View;

import java.awt.event.*;

import javax.swing.*;

import MineSweeperGame.Model.Menu.MenuButtons.subButtons.*;

public class Menu extends JFrame {
    public Menu(){

        setTitle("Difficulties");

        initComponents();

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    private void initComponents(){
        creator();
        adder();
    }


    private void creator(){

        mainPanel = new JPanel();

        difficulties = new JLabel("Difficulties: ");

        beginner = new beginnerButton();
        intermediate = new intermediateButton();
        expert = new expertButton();

        buttonActions();
    }

    private void adder(){
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
