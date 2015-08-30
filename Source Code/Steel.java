import greenfoot.*;

/**
 * Write a description of class Steel here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Steel extends Hurdle
{
    public boolean power;
    public Steel(boolean powerup)
    {
        power = powerup;
    }
    /**
     * Act - do whatever the Steel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((((Level) getWorld()).powerCounter) > 0 && power)
        {
            if(((Level) getWorld()).powerCounter == 3000) getWorld().removeObject(this);
            else  ((Level) getWorld()).powerCounter++;
        }
    }    
}
