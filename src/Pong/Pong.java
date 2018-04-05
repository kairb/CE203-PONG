package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kairo on 06/12/2017.
 */
public class Pong{
    public static int width = 500, height = 500;
    public static void main(String[] args){
        //creating instance of JFrame
        JFrame frame = new JFrame("Kai Roper-Blackman (1602999)");
        frame.setSize(width+5,height+100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JPanel top = new JPanel();

        frame.add(top, BorderLayout.NORTH);

        JButton newGame = new JButton("New Game");
        top.add(newGame);
        JButton scores = new JButton(("High scores"));
        top.add(scores);

        //creating new old object and adding to JFrame
        Game grid = new Game(width, height);
        frame.add(grid, BorderLayout.CENTER);

        newGame.addActionListener(new buttonHandler(1,grid));
        scores.addActionListener(new buttonHandler(2,grid));


        //revalidating JFrame
        frame.revalidate();

    }
}
//button handler action listener.
class buttonHandler implements ActionListener{
    int button;
    Game theApp;
    public buttonHandler(int button, Game grid){
        this.button = button;
        this.theApp = grid;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (button == 1){
            theApp.reset();

        }else if (button == 2){
            theApp.displayScores();
            theApp.addNotify();


        }
    }
}
