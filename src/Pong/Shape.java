package Pong;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kairo on 28/11/2017.
 */

//abstract class for shapes
public abstract class Shape extends JPanel {
    public Color c;
    public int x, y;

    public Shape(Color c, int x, int y) {
        this.c = c;
        this.x = x;
        this.y = y;
    }
    //draws shape to screen
    public void draw(Graphics g){}

    public void moveDown(){}

    public void moveUp(){}

    public void ballMove(){}

    //returns x postion
    public int getX(){
        return this.x;
    }
    //returns y position
    public int getY(){
        return this.y;
    }

    //moves computer ball
    public void moveComputer(int y){}

    //resets ball to initial position
    public void ballReset(){}

    //checks collision between ball and paddles
    public void checkCollision(Shape paddle1, Shape paddle2){

    }


}

