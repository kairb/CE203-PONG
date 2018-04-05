package Pong;

import java.awt.*;

/**
 * Created by kairo on 04/12/2017.
 */

//unused class
public class Circle extends Shape {
    //stores width and height of circle
    public int width;
    public int height;
    //stores fill
    public boolean fill;

    //constructor
    public Circle(Color c, int x, int y, int width, int height,boolean fill){
        super(c,x,y);
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    //draws circle to screen
    public void draw(Graphics g){
        g.setColor(c);
        if (this.fill){
            g.fillOval(x, y, width, height);
        }else{
            g.drawOval(x, y, width, height);
        }
    }
}

