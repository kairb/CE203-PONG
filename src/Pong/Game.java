package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kairo on 05/12/2017.
 */
public class Game extends JPanel implements Runnable, KeyListener{
    //holds grid of squares
    public ArrayList<Shape> shapes = new ArrayList<>();
    //height and width of frame
    public int width, height;
    //thread
    Thread thread;
    //instance variable of player paddle
    public Shape player;
    //instance variable of ball
    public Shape ball;
    //instance variable of score
    public Score score;
    //instance variable of computer paddle
    public Shape computer;
    //instance of highscore
    public HighScores scores = new HighScores();

    //giving JFrame key listener focus
    public void addNotify(){
        super.addNotify();
        requestFocus();
    }

    //constructor
    public Game(int width, int height){
        this.width = width;
        this.height = height;

        for (int i = 0; i < width; i += width / 20) {
            for (int j = 0; j < height; j += height / 20) {
                Shape temp = new Square(Color.LIGHT_GRAY,i,j,width/20,false);
                shapes.add(temp);
            }
        }

        player = new Paddle(Color.BLACK,475,200,25,100);
        computer = new Paddle(Color.BLACK,0,200,25,100);
        ball = new Ball(Color.BLACK,250,250,25);
        score = new Score();
        this.repaint();
        addKeyListener(this);


        thread = new Thread(this);
        //start thread after instance variables constructed
        thread.start();

    }
    //resets grid for and restarts thread
    public void reset(){
        thread.stop();
        player = new Paddle(Color.BLACK,475,200,25,100);
        computer = new Paddle(Color.BLACK,0,200,25,100);
        ball = new Ball(Color.BLACK,250,250,25);
        score = new Score();
        this.addNotify();
        thread = new Thread(this);
        thread.start();

    }
    //draws grid of squares, the ball, paddles, and scores
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
        score.draw(g);
        player.draw(g);
        computer.draw(g);
        ball.draw(g);
    }
    //run method called by thread start
    public void run(){
        long start = System.currentTimeMillis();
        JOptionPane.showMessageDialog(null, "How long can you survive for? You have 5 lives");
        while(score.win()){
            try{
                //set old to sleep for 15millis before next update
                thread.sleep(15);

                //move ball
                ball.ballMove();
                //move computer paddle and check collision between balls and paddles
                computer.moveComputer(ball.getY());
                ball.checkCollision(computer,player);

                //checking if ball reaches opponent/ own side, if so, update sore accordingly
                if (ball.getX() > 500){
                    ball.ballReset();
                    score.updateComputerScore();
                }else if (ball.getX() < 0){
                    ball.ballReset();
                    score.updatePlayerScore();
                }
                //System.out.println(ball.getX() + " " + ball.getY());
                //repaint to see frame updates
                repaint();



            }catch(InterruptedException e){
            }

        }
        long end = System.currentTimeMillis();
        scores.add((end - start)/1000);

        //input is time in seconds survived
        //this.scores = new HighScores(((end - start)/1000));

        //new HighScores object to display all time high score in new window

    }
    //display window of scores
    public void displayScores(){
        scores.display();
    }

    //methods to listen to key press and then call player paddle
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_DOWN){
            player.moveDown();
            repaint();
        }else if(keyCode == KeyEvent.VK_UP){
            player.moveUp();
            repaint();
        }else if(keyCode == KeyEvent.VK_SPACE){
            thread.start();
            repaint();
        }
    }
    //unused but needed in implementation
    public void keyTyped(KeyEvent e){
    }

    public void keyReleased(KeyEvent e){
    }


}
