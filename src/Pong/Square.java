package Pong;

import java.awt.*;

/**
 * Created by kairo on 06/12/2017.
 */

//square class used for creating grid
public class Square extends Shape {
    public int size;
    public boolean fill;

    //contstructor
    public Square(Color c, int x, int y, int size, boolean fill){
        super(c,x,y);
        this.size = size;
        this.fill = fill;
    }

    //draws square screen
    public void draw(Graphics g){
        g.setColor(c);
        if (this.fill){
            g.fillRect(x, y, this.size, this.size);
        }else{
            g.drawRect(x, y, this.size, this.size);
        }
    }

}