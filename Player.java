import greenfoot.*;

/**
 * Write a description of class Player here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Player extends Tank
{
    public int direction;
    public int playerImage;
    public int onlyOne;
    public String key;
    public int moveCount;

    /**
     * Constructs Player
     */
    public Player()
    {
        image = true;
        setImage("player_1.png");
        turn(-90);
        direction = 4;
        playerImage = 1;
        onlyOne = 30;
        moveCount = 4;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY();

        //player movement
        if(Greenfoot.isKeyDown("right"))
        {
            direction = turnTank(1);
            moveCount = moveTank(4, direction);
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            direction = turnTank(3);
            moveCount = moveTank(4, direction);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            direction = turnTank(2);
            moveCount = moveTank(4, direction);
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            direction = turnTank(4);
            moveCount = moveTank(4, direction);
        }
        else if(moveCount < 4)  moveCount = moveTank(moveCount, direction);

        //player shooting
        onlyOne = canShoot(onlyOne);
        if(onlyOne == 30 && Greenfoot.isKeyDown("space"))
        {
            fire(x, y, direction, false);
            onlyOne = 1;
        }

        //player power-ups picking.
        Actor powerup = getOneObjectAtOffset(0,0,Time_Power.class);
        if(powerup != null)
        {
            ((Level) getWorld()).timePower = 1;
            getWorld().removeObject(powerup);
            Greenfoot.playSound("powerup_pick.wav");

        }
        powerup = getOneObjectAtOffset(0,0,Eagle_Protect.class);
        if(powerup != null)
        {
             ((Level) getWorld()).eagleProtect();
             ((Level) getWorld()).powerCounter = 1;
             getWorld().removeObject(powerup);
             Greenfoot.playSound("powerup_pick.wav");

        }
        powerup = getOneObjectAtOffset(0,0,Grenade.class);
        if (powerup != null)
        {
            ((Grenade) powerup).grenadeBlast();
            getWorld().removeObject(powerup);
            Greenfoot.playSound("powerup_pick.wav");

        }
        if(((Level) getWorld()).timePower > 0)
        {
            if( ((Level) getWorld()).timePower == 300 )  ((Level) getWorld()).timePower = 0;
            else  ((Level) getWorld()).timePower++;
        }

    
    }

}
