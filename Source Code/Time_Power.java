import greenfoot.*;

/**
 * Write a description of class Time_Power here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Time_Power extends Powerups
{
    int counter = 0;
    int timeCounter = 0;
    /**
     * Act - do whatever the Time_Power wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkSteel();
        
        //Blink
        if (counter == 5)
        {
            setImage("powerup_timer.png");
            counter++;
        }
        else if(counter == 10)
        {
            setImage(new GreenfootImage(32,32));
            counter = 0;
        }
        else counter++;
        
         //disappear after some time
        timeCounter++;
        if(timeCounter == 1000) getWorld().removeObject(this);

    }
}
