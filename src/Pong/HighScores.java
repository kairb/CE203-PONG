package Pong;

import javax.swing.*;
import java.util.*;

/**
 * Created by kairo on 07/12/2017.
 */
public class HighScores {
    public Vector<Vector<String>> scores;
    public TextParser parser;
    public JTextPane scoreBoard;
    public JFrame scoreFrame;

    // constructor creates new text parser
    public HighScores(){
        parser = new TextParser();
    }

    //add new score to text file
    public void add(long survived){
        JOptionPane.showMessageDialog(null, "You survived for " + survived + " seconds!");
        parser.add(survived);
    }


    //display scores on score window
    public void display(){

       //creating new jframe to display scores
        scoreFrame = new JFrame("High scores");
        scoreFrame.setSize(500,500);
        scoreFrame.setVisible(true);
        scoreBoard = new JTextPane();
        scoreFrame.add(scoreBoard);

        //getting high scores from text file
        scores = parser.returnVector();

        scoreBoard.setText("All time top scores\n\n");

        //printing high scores from vector
        for (int i = 0; i < scores.size() && i < 10; i++){
            Vector<String> temp = scores.get(i);

            scoreBoard.setText(scoreBoard.getText() + (i+1) + ". Seconds: " + temp.get(1) +" Date: " + temp.get(2) +" Time: " +  temp.get(3) + "\n");
        }

        scoreBoard.setText(scoreBoard.getText() + "\n\nTop scores in last 24 hours\n\n");

        //printing highest scores in last 24 hours
        int count = 0;
        for (int i = 0; i < scores.size(); i++){
            if (count >9){
                break;
            }
            Vector<String> temp = scores.get(i);
            //if score was recorded less than 24 hours ago (86400000 milliseconds) then add to scoreboard
            if ((System.currentTimeMillis()) - (Long.parseLong(temp.get(0))) <= 86400000){
                scoreBoard.setText(scoreBoard.getText() + (count+1) + ". Seconds: " + temp.get(1) +" Date: " + temp.get(2) +" Time: " +  temp.get(3) + "\n");
                count++;
            }
        }
        //revalidating scoreboard
        scoreFrame.revalidate();
    }
}

//day = 86400000

