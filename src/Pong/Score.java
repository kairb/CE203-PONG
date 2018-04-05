package Pong;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kairo on 06/12/2017.
 */

//score class to diplay save highscores
public class Score extends JPanel{
    //defining score variables
    private int playerScore;
    private int computerScore;

    //constructor initialises values to 0
    public Score(){
        this.playerScore = 0;
        this.computerScore = 0;
    }

    //returns players score
    public int getPlayerScore(){
        return this.playerScore;
    }

    //returns computers score
    public int getComputerScore(){
        return this.computerScore;
    }

    //increases player score
    public void updatePlayerScore(){
        this.playerScore += 1;
    }

    //increase computer score
    public void updateComputerScore(){
        this.computerScore +=1;
    }

    //draw method to draw scores to screen
    public void draw(Graphics g){

        g.setColor(Color.red);
        g.setFont(new Font("Times Roman", Font.PLAIN,60));
        g.drawString(Integer.toString(this.computerScore),125,50);

        g.drawString(Integer.toString(this.playerScore),375,50);
    }

    //check for win, if so return false. player wins at 5 points
    public boolean win(){
        if (this.playerScore == 5 || this.computerScore == 5){
            return false;
        }else{
            return true;
        }
    }
}
