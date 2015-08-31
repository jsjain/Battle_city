import greenfoot.*;
import java.awt.Color;
import java.util.List;
import java.awt.Font;

/**
 * Write a description of class Stage_Cleared here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Stage_Cleared extends Displays
{
    public int levels;
    public boolean removeFlag = true;
    public Stage_Cleared(int level)
    {
        GreenfootImage img = new GreenfootImage(300,100);
        img.setColor(Color.WHITE);
        img.setFont(new java.awt.Font("Helvetica", Font.BOLD, 20));
        img.drawString("Stage Completed", 20, 30);
        img.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 15));
        img.drawString("Press Enter to Start Level "+level, 20, 80);
        setImage(img);
        levels = level;


    }

    /**
     * Act - do whatever the Stage_Cleared wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(removeFlag)
        {
            List <Game_Objects> game_object = getObjectsInRange(800, Game_Objects.class);
            for(Game_Objects g_obj: game_object)
            {
                getWorld().removeObject(g_obj);
            }
            
            removeFlag = false;
        }
        if(Greenfoot.isKeyDown("enter"))
        {
            ((Level) getWorld()).prepare(levels);
            getWorld().removeObject(this);
        }
    }
}
