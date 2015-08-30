import greenfoot.*;

/**
 * Write a description of class Tank here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Tank extends Game_Objects
{
    public boolean flagHurdle = true;
    public boolean image = true;
    int animateCounter = 0;
    /**
     * Act - do whatever the Tank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    /**
     * Shoots Bullet
     */
    public void fire(int x, int y, int direction, boolean enemyBullet)
    {
        Bullet bullet = new Bullet(direction, enemyBullet);
        if( direction == 2 && y < getWorld().getHeight()-21)
        {
            getWorld().addObject(bullet, x, y+24);
        }
        else if( direction == 3 && x > 21)
        {
            getWorld().addObject(bullet, x-24, y);
        }
        else if( direction == 4 && y > 21)
        {
            getWorld().addObject(bullet, x, y-24);
        }
        else if( direction == 1 && x < getWorld().getWidth()-101)
        {
            getWorld().addObject(bullet, x+24, y);
        }
        Greenfoot.playSound("bullet_shot.wav");
    }

    /**
     * Checks if tank can shoot a bullet
     */
    public int canShoot(int onlyOne)
    {
        if(onlyOne != 30) onlyOne++;
        return onlyOne;
    }

    /**
     * Turns the tank to the given direction
     */
    public int turnTank(int direction)
    {
        if(direction == 2) setRotation(90);
        else if(direction == 3) setRotation(180);
        else if(direction == 4) setRotation(-90);
        else setRotation(0);
        return direction;
    }

    /**
     * Moves tank for a number of acts
     */
    public int moveTank(int moveCount, int direction)
    {
        if(moveCount > 0)
        {
            moveCount--;
            int x = getX();
            int y = getY();

            Actor hurdle1 = null;
            Actor hurdle2 = null;
            Actor hurdle3 = null;
            if(direction == 1 && x < getWorld().getWidth()-97)
            {
                hurdle1 = getOneObjectAtOffset(18, 14, Hurdle.class);
                hurdle2 = getOneObjectAtOffset(18, -14, Hurdle.class);
                hurdle3 = getOneObjectAtOffset(18, 0, Hurdle.class);
                flagHurdle = true;
            }
            else if(direction == 2 && y < getWorld().getHeight()-17)
            {
                hurdle1 = getOneObjectAtOffset(+14, +18, Hurdle.class);
                hurdle2 = getOneObjectAtOffset(-14, +18, Hurdle.class);
                hurdle3 = getOneObjectAtOffset(0, 18, Hurdle.class);
                flagHurdle = true;
            }
            else if(direction == 3 && x > 17)
            {
                hurdle1 = getOneObjectAtOffset(-18, +14, Hurdle.class);
                hurdle2 = getOneObjectAtOffset(-18, -14, Hurdle.class);
                hurdle3 = getOneObjectAtOffset(-18, 0, Hurdle.class);
                flagHurdle = true;
            }
            else if(direction == 4 && y > 17)
            {
                hurdle1 = getOneObjectAtOffset(+14, -18, Hurdle.class);
                hurdle2 = getOneObjectAtOffset(-14, -18, Hurdle.class);
                hurdle3 = getOneObjectAtOffset(0, -18, Hurdle.class);
                flagHurdle = true;
            }
            else flagHurdle = false;
            if(hurdle1 == null && hurdle2 == null && hurdle3 == null && flagHurdle)
            {
                if(direction == 1 && x < getWorld().getWidth()-97)
                {
                    hurdle1 = getOneObjectAtOffset(18, 14, Tank.class);
                    hurdle2 = getOneObjectAtOffset(18, -14, Tank.class);
                    hurdle3 = getOneObjectAtOffset(18, 0, Tank.class);
                    flagHurdle = true;
                }
                else if(direction == 2 && y < getWorld().getHeight()-17)
                {
                    hurdle1 = getOneObjectAtOffset(+14, +18, Tank.class);
                    hurdle2 = getOneObjectAtOffset(-14, +18, Tank.class);
                    hurdle3 = getOneObjectAtOffset(0, 18, Tank.class);
                    flagHurdle = true;
                }
                else if(direction == 3 && x > 17)
                {
                    hurdle1 = getOneObjectAtOffset(-18, +14, Tank.class);
                    hurdle2 = getOneObjectAtOffset(-18, -14, Tank.class);
                    hurdle3 = getOneObjectAtOffset(-18, 0, Tank.class);
                    flagHurdle = true;
                }
                else if(direction == 4 && y > 17)
                {
                    hurdle1 = getOneObjectAtOffset(+14, -18, Tank.class);
                    hurdle2 = getOneObjectAtOffset(-14, -18, Tank.class);
                    hurdle3 = getOneObjectAtOffset(0, -18, Tank.class);
                    flagHurdle = true;
                }
                else flagHurdle = false;
                if(hurdle1 == null && hurdle2 == null && hurdle3 == null && flagHurdle)
                {
                    move(2);
                    if (animateCounter == 5)
                    {
                        animateCounter = 0;
                        if (this instanceof Player )
                        {
                            if(image)
                            {
                            setImage("player_2.png");
                            image = false;
                            }
                            else
                            {
                            setImage("player_1.png");
                            image = true;
                            }
                        }
                        else if (this instanceof Genemy )
                        {
                            if(image)
                            {
                            setImage("Genemy_2.png");
                            image = false;
                            }
                            else
                            {
                            setImage("Genemy_1.png");
                            image = true;
                            }
                        }
                        else if (this instanceof Penemy )
                        {
                            if(image)
                            {
                            setImage("Penemy_2.png");
                            image = false;
                            }
                            else
                            {
                            setImage("Penemy_1.png");
                            image = true;
                            }
                        }
                        else if (this instanceof Senemy )
                        {
                            if(image)
                            {
                            setImage("Senemy_2.png");
                            image = false;
                            }
                            else
                            {
                            setImage("Senemy_1.png");
                            image = true;
                            }
                        }
                    }
                    else animateCounter++;
                }
                /*if(image)
                {
                setImage("player_2.png");
                image = false;
                }
                else
                {
                setImage("player_1.png");
                image = true;
                }*/
            }

            return moveCount;
        }
        else return 30;
    }
}
