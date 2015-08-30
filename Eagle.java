import greenfoot.*;

/**
 * Write a description of class Eagle here.
 * 
 * @author  Shubham Jain and Rohit Navarathna 
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Eagle extends Hurdle
{
    /**
     * Eagle Contructor
     */
    public Eagle()
    {
        setImage("base.png");
    }

    /**
     * Act - do whatever the Eagle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if(bullet != null)
        {
            if(bullet.bigc < 2 && bullet.smallc < 2)
            {
                setImage("base_destroyed.png");
                Game_Over gameover = new Game_Over();
                getWorld().addObject(gameover, getWorld().getWidth()/2 - 40, getWorld().getHeight()/2);
                Greenfoot.playSound("game_over.wav");
                Greenfoot.stop();
            }
        }
    }    
}
