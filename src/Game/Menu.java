package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    private JLabel difficulties;
    private JPanel mainPanel;
    private JButton beginner, intermediate, expert;

    public Menu(){
        creatorMethod();
        addMethod();

        //  setMinimumSize(new Dimension(600,750));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void creatorMethod(){
        mainPanel = new JPanel(new FlowLayout());

        setTitle("Minesweeper");
        
        // Label of buttons
        difficulties = new JLabel("Difficulties: ");

        buttonsCreator();
    }

    private void setVisibilities(){
        //  Setting the visibility of Menu as false and Game as true
        Game.getGame().setVisible(true);
        setVisible(false);
    }

    private void expertButton(){
        Game.setGame(null);
        Game.getGame();
        Game.setGame(new Game("expert"));

        setVisibilities();
    }

    private void intermediateButton(){
        Game.setGame(null);
        Game.getGame();
        Game.setGame(new Game("intermediate"));
        
        setVisibilities();
    }

    private void beginnerButton(){
        Game.setGame(null);
        Game.getGame();
        Game.setGame(new Game("beginner"));
        
        setVisibilities();
        // System.out.println("theGame: " + Game.getGame());
    }

    private void addMethod(){
        mainPanel.add(difficulties);
        mainPanel.add(beginner);
        mainPanel.add(intermediate);
        mainPanel.add(expert);
        add(mainPanel);
    }

    private void buttonsCreator(){
        beginner = new JButton("Beginner");
        beginner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginnerButton();
            }
        });

        intermediate = new JButton("Intermediate");
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intermediateButton();
            }
        });

        expert = new JButton("Expert");
        expert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertButton();
            }
        });
    }

}