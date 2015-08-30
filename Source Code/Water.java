import greenfoot.*;

/**
 * Write a description of class Water here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Water extends Hurdle
{
    int counter = 0;
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(counter == 5) setImage("water_1.png");
        else if(counter == 10)
        {
            setImage("water_2.png");
            counter = 0;
        }
        counter++;
    }    
}
