package Pong;

import java.awt.*;

/**
 * Created by kairo on 06/12/2017.
 */
public class Ball extends Shape {
    //holds size of ball
    public int size;
    //holds xVel and yVel
    public double xVelocity, yVelocity;

    public Ball(Color c, int x, int y, int size){
        super(c,x,y);
        this.size = size;
        this.xVelocity = -3;
        this.yVelocity = 2;

    }
    //moves ball. reverses velocity if ball hits side
    public void ballMove(){
        this.x +=xVelocity;
        this.y +=yVelocity;

        if (this.y < 0){
            yVelocity = -yVelocity;
        }if (this.y >475){
            yVelocity = -yVelocity;
        }
    }

    //resets ball position and velocity
    public void ballReset(){
        this.x = 250;
        this.y = 250;
        this.xVelocity = -3;
        this.yVelocity = 2;
    }

    //draw ball to screen
    public void draw(Graphics g){
        g.setColor(c);
        g.fillOval(x,y,this.size,this.size);
    }

    //checks colision between paddle and ball, if so reverse velocity
    public void checkCollision(Shape paddle1, Shape paddle2){
        if(this.x < 25){
            if(this.y >= paddle1.getY() && this.y <= paddle1.getY() +100 ){
                this.xVelocity = -xVelocity;
            }
        }else if(this.x >450){
            if(this.y >= paddle2.getY() && this.y <= paddle2.getY() +100 ){
                this.xVelocity = -xVelocity;
            }

        }
    }

}

