import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Bullet here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Bullet extends Game_Objects
{
    public static final int GRID_SIZE = 32;
    public boolean enemyBullet;
    public int bigc = 1;
    public int smallc = 1;
    /**
     * Constructs a bullet
     */
    public Bullet(int direction, boolean flag)
    {
        enemyBullet = flag;
        setImage("bullet.png");
        if(direction == 2) turn(90);
        else if(direction == 3) turn(180);
        else if(direction == 4) turn(-90);
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY();
        Level world = (Level) getWorld();


        if(bigc < 2 && smallc < 2)
        {
            Tank tank = (Tank) getOneIntersectingObject(Tank.class);
            Brick brick = (Brick) getOneIntersectingObject(Brick.class);
            Steel steel = (Steel) getOneIntersectingObject(Steel.class);
            if(tank != null)
            {
                if(tank instanceof Enemy && !enemyBullet)
                {
                    if(tank instanceof Senemy)
                    {
                        //System.out.println(((Senemy) tank).bullets);
                        if (((Senemy) tank).bullets == 2)
                        {
                            bigc = bigExplosion(x, y, bigc);
                            getWorld().removeObject(tank);
                            reduceEnemyLife();
                            Greenfoot.playSound("explosion_2.wav");
                            world.addScoreW(400);
                        }
                        else
                        {
                            ((Senemy) tank).bullets++;
                            world.removeObject(this);
                        }
                    }
                    else if(tank instanceof Penemy)
                    {
                        //System.out.println(((Penemy) tank).bullets);
                        if (((Penemy) tank).bullets == 1)
                        {
                            bigc = bigExplosion(x, y, bigc);
                            getWorld().removeObject(tank);
                            reduceEnemyLife();
                            Greenfoot.playSound("explosion_2.wav");
                            world.addScoreW(200);
                        }
                        else
                        {
                            ((Penemy) tank).bullets++;
                            getWorld().removeObject(this);
                        }
                    }
                    else
                    {
                        bigc = bigExplosion(x, y, bigc);
                        getWorld().removeObject(tank);
                        reduceEnemyLife();
                        Greenfoot.playSound("explosion_2.wav");
                        world.addScoreW(100);
                    }
                }
                else if(tank instanceof Player && enemyBullet)
                {
                    bigc = bigExplosion(x, y, bigc);
                    getWorld().removeObject(tank);
                    Greenfoot.playSound("explosion_2.wav");
                    reducePlayerLife();
                }
                else getWorld().removeObject(this);
            }
            else if ( x < 4 || x > getWorld().getWidth()-84 || y < 4 || y > getWorld().getHeight()-4 )
            {
                smallc = explosion(x, y, smallc);
            }
            else if ( brick !=null )
            {
                smallc = explosion(x, y, smallc);
                getWorld().removeObject(brick);
            }
            else if( steel != null )
            {
                smallc = explosion(x, y, smallc);
            }
            else move(5);
        }
        else if(bigc > 1) bigc = bigExplosion(x, y, bigc);
        else smallc = explosion(x, y, smallc);
    }

    /**
     * makes big explosion after intersection with Tank.
     */
    public int bigExplosion(int x, int y, int c)
    {
        if(c%2 == 0) setImage("big_explosion_" + c/2 + ".png");
        if(c == 10)
        {
            c = 0;
            getWorld().removeObject(this);
        }
        else c++;
        return c;
    }

    /**
     * makes small explosion after intersection.
     */
    public int explosion(int x, int y, int c)
    {
        if(c%2 == 0) setImage("explosion_" + c/2 + ".png");
        if(c == 6)
        {
            c = 0;
            getWorld().removeObject(this);
        }
        else c++;
        return c;
    }

    /**
     * Reduces enemy life
     */
    public void reduceEnemyLife()
    {
        Level world = (Level) getWorld();
        world.eLives--;
        if(world.eLives+1 > 0)
        {
            world.removeObject(world.eToKill[(world.eLives)]);

            respawnEnemy();
        }
        else if(world.eLives < -2)
        {
            world.nextLevel();
        }
    }

    /**
     * Respawns a new enemy
     */
    public void respawnEnemy()
    {
        int random = Greenfoot.getRandomNumber(100);
        int randomPosition = GRID_SIZE/2+GRID_SIZE*10*Greenfoot.getRandomNumber(3);
        if (random < 20)
        {
            getWorld().addObject(new Senemy(), randomPosition, GRID_SIZE/2);
        }
        else if (random >= 20 && random < 50)
        {
            getWorld().addObject(new Penemy(), randomPosition, GRID_SIZE/2);
        }
        else  getWorld().addObject(new Genemy(), randomPosition, GRID_SIZE/2);
    }

    /**
     * Reduces Player Life
     */
    public void reducePlayerLife()
    {
       Level world = (Level) getWorld();
        world.pLives--;
        if(world.pLives+1 > 0)
        {
            world.removeObject(world.pToKill[world.pLives]);

            world.respawnPlayer();
        }
        else
        {
            Game_Over gameover = new Game_Over();
            getWorld().addObject(gameover, getWorld().getWidth()/2 - 40, getWorld().getHeight()/2);
            Greenfoot.playSound("game_over.wav");
            Greenfoot.stop();
        }
    }

   

}
