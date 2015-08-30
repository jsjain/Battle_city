import greenfoot.*;

/**
 * Write a description of class Genemy here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Genemy extends Enemy
{
    public int direction;

    /**
     * Constructs a green enemy (100 points)
     */
    public Genemy()
    {
        setImage("Genemy_1.png");
        direction = 2;
        turnTank(2);
    }
    /**
     * Act - do whatever the Genemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        direction = randomMove(direction);
        randomShoot(getX(), getY(), direction);


    }
}
