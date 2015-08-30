import greenfoot.*;

/**
 * Write a description of class Battle_City here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Battle_City extends Displays
{
    int x;
    int y;
    boolean soundFlag = true;
    boolean textFlag = true;

    /**
     * Constructs the welcome banner
     */
    public Battle_City()
    {
        setImage("battle_city.png");
    }
    /**
     * Act - do whatever the Battle_City wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       x = getX();
       y = getY();
       if(soundFlag)
       {
           Greenfoot.playSound("stage_start.wav");
           soundFlag = false;
        }
       if(y > getWorld().getHeight()/2)
       {
           turn(-90);
           move(4);
           turn(90);
       }
       else if(textFlag)
       {
           getWorld().showText("Press Enter to start the Game", getWorld().getWidth()/2, getWorld().getHeight()/2+200);
           textFlag = false;
        }
       if(Greenfoot.isKeyDown("enter"))
       {
           getWorld().showText("", getWorld().getWidth()/2, getWorld().getHeight()/2+200);
           ((Level) getWorld()).prepare(1);
            getWorld().removeObject(this);
        }
    }
}
