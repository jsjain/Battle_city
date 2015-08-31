import greenfoot.*;

/**
 * Write a description of class Powerups here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Powerups extends Game_Objects
{
    /**
     * Act - do whatever the Powerups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    /**
     * Prevents powerups from spawning on steel or water
     */
    public void checkSteel()
    {
        if(getOneIntersectingObject(Steel.class) != null && getOneIntersectingObject(Water.class) != null)
        {
            ((Level) getWorld()).spawnPowerup();
            getWorld().removeObject(this);
        }
    }
}
