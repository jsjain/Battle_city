import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Winner here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Winner extends Displays
{
    public Winner()
    {
        GreenfootImage winner = new GreenfootImage(200,50);
        winner.setColor(Color.BLACK);
        winner.fillRect(0, 0, 200, 50);
        winner.setColor(Color.WHITE);
        winner.drawString("WINNER!", 2, 20);
    }
    /**
     * Act - do whatever the Winner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
