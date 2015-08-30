import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Counter here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Counter extends Displays
{
    int i = 1;
    int score = 0;
    GreenfootImage img = new GreenfootImage(100, 40);
    public int playerRespawnCounter = 0;
    
    /**
     * makes counter
     */
    public Counter()
    {

        img.setColor(Color.BLACK);
        img.setFont(new java.awt.Font("Helvetica", Font.BOLD, 15));
        img.drawString("score",10,20);
        img.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 20));
        img.drawString(String.valueOf(score), 10, 40);
        setImage(img);
    }

    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(playerRespawnCounter > 0)
        {
            playerRespawnCounter++;
        }
        if(playerRespawnCounter == 30)
        {
            playerRespawnCounter = 0;
            getWorld().addObject(new Player(), getWorld().getWidth()/2-100, 18*32-5);
        }
        
        if (score > i*500)
        {
            i++;
            ((Level) getWorld()).spawnPowerup();
        }
    }

    /**
     * adds score to Counter
     */
    public void addScore(int points)
    {
        score = score + points;
        img = new GreenfootImage(80,40);
        img.setColor(Color.BLACK);
        img.setFont(new Font("Default", 1, 15));
        img.drawString("score",10,20);
        img.setFont(new Font("Default", 1, 20));
        img.drawString(String.valueOf(score), 10, 40);
        setImage(img);
    }
}
