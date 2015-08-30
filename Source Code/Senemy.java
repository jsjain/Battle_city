import greenfoot.*;

/**
 * Write a description of class Senemy here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Senemy extends Enemy
{
    public int bullets = 0;
    public int direction;

    /**
     * Constructs a silver enemy (400 points)
     */
    public Senemy()
    {
        setImage("Senemy_1.png");
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
