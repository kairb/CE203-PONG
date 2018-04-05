package Pong;

import java.awt.*;
import java.util.Random;

/**
 * Created by kairo on 05/12/2017.
 */
public class Paddle extends Shape {
    //stores width an height paddle
    public int width;
    public int height;
    //public int yVelocity;

    //constructor
    public Paddle(Color c, int x, int y, int width, int height){
        super(c,x,y);
        this.width = width;
        this.height = height;
        //this.yVelocity = 3;
    }

    //draws paddle to screen
    public void draw(Graphics g){
        g.setColor(c);
        g.fillRect(x, y, this.width, this.height);

    }

    //moves paddle down by 25 pixels
    public void moveDown(){
        if(this.y < 400){
            this.y += 25;
        }
    }

    //moves paddle up by 25 pixels
    public void moveUp(){
        if(this.y >0){
            this.y -= 25;
        }
    }

    //moves computer paddle to position of ball.
    // originally, the paddle would move up and randomly
    public void moveComputer(int y) {
        this.y = y - 35;
    }
}
