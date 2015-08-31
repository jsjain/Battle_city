import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Enemy extends Tank
{
    public int count = 0;
    public int random;
    public int onlyOne = 30;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Random movement of enemies
     */
    public int randomMove(int direction)
    {
        if(((Level) getWorld()).timePower == 0)
        {
            moveTank(4,direction);
            if(count == 30)
            {
                random = Greenfoot.getRandomNumber(100);
                if(random < 50) direction = 2;
                else if(random >= 50 && random < 70 ) direction = 3;
                else if(random >= 70 && random < 90) direction = 1;
                else direction = 4;
                count = 0;
            }
            else count++;
            turnTank(direction);
            return direction;
        }
        else return direction;
    }
    
    /**
     * Shoots bullet randomly
     */
    public void randomShoot(int x, int y, int direction)
    {
         if(((Level) getWorld()).timePower == 0)
         {
            onlyOne = canShoot(onlyOne);
            if(onlyOne == 30 && Greenfoot.getRandomNumber(100) < 30)
            {
                fire(x, y, direction, true);
                onlyOne = 1;
            }
        }
    }
}
