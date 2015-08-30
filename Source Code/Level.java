import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Background here.
 *
 * @author  Shubham Jain and Rohit Navarathna
 * @version 1.0 Last Modified on - 23/8/2015
 */
public class Level extends World
{
    public static final int GRID_SIZE = 32;
    public int level = 1;
    public int eLives = 5;
    public int pLives = 3;
    public EToKill[] eToKill = new EToKill[10];
    public PToKill[] pToKill = new PToKill[4];
    public Eagle eagle;
    public Counter counter;
    public int timePower = 0;
    public int powerCounter = 0;
    /**
     * Constructor for objects of class Level 1.
     *
     */
    public Level()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(784, 586, 1);
        setPaintOrder(Winner.class, Game_Over.class, Tree.class);
        GreenfootImage back = getBackground();
        back.setColor(Color.BLACK);
        back.fill();
        back.setColor(new Color(100,100,100));
        back.fillRect(getWidth()-80, 0, 80, getHeight());
        counter = new Counter();
        Battle_City welcome = new Battle_City();
        addObject(welcome, getWidth()/2, getHeight());

    }

    /**
     * makes 1 new brick at x and y
     */
    public void newBrick(int type, int x, int y)
    {
        if(type == 1) addObject(new Brick(), x, y);
        else if(type == 2) addObject(new Steel(false), x, y);
        else if(type == 3) addObject(new Tree(), x, y);

    }

    /**
     * prepareWorld
     */
    public void prepare(int level_no)
    {
        addObject(counter, getWidth()-30, getHeight()/2);
        if(level_no == 1)
        {
            level_1_Create();
        }
        else if (level_no == 2)
        {
            level_2_Create();
        }
    }

    /**
     * Make eagle and surrounding bricks
     */
    public void eaglePlace()
    {
        int x = getWidth()/2 -40;
        int y = getHeight();
        newBrick(1,x - 24, y - 8);
        newBrick(1,x - 24, y - 24);
        newBrick(1,x - 24, y - 40);
        newBrick(1,x - 8,y - 40);
        newBrick(1,x + 8,y - 40);
        newBrick(1,x + 24,y - 40);
        newBrick(1,x + 24,y - 24);
        newBrick(1,x + 24,y - 8);
        eagle = new Eagle();
        addObject(eagle, x, y-15);
    }

    /**
     * Places enemy lives indicator
     */
    public void eToKillPlace(int eLives)
    {

        int x = getWidth()-51;
        int y = 28;
        for(int i = 0; i < eLives; i++)
        {
            eToKill[i] = new EToKill();
            if(i%2 == 0)
            {
                addObject(eToKill[i], x, 20+((16+5)*i/2));
            }
            else
            {
                addObject(eToKill[i], x+21, 20+((16+5)*(i-1)/2));
            }
        }
    }

    /**
     * respawns enemy at one of 3 locations randomly
     */
    public void respawnEnemy()
    {
        int random = Greenfoot.getRandomNumber(3);
        //if(random == 0)
        //{addObject(
    }

    /**
     * Places player lives indicator
     */
    public void pToLivePlace(int pLives)
    {

        int x = getWidth()-51;
        int y = getHeight()-28;
        for(int i = 0; i < pLives; i++)
        {
            pToKill[i] = new PToKill();
            if(i%2 == 0)
            {
                addObject(pToKill[i], x, y-((16+5)*i/2));
            }
            else
            {
                addObject(pToKill[i], x+21, y-((16+5)*(i-1)/2));
            }
        }
    }

    /**
     * place 4 brick at a time
     */
    public void placeBrick(int type, int x, int y)
    {
        if(type == 4)
        {
            addObject(new Water(), x, y);
        }
        else
        {
            newBrick(type,x-8, y-8);
            newBrick(type,x-8, y+8);
            newBrick(type,x+8, y-8);
            newBrick(type,x+8, y+8);
        }
    }

    /**
     * place brick in line of given length
     */
    public void makeWall(int type,int x, int y, int xLength, int yLength)
    {

        for(int i = 0; i < xLength; i++)
        {
            for(int j = 0; j < yLength; j++)
            {
                placeBrick(type,(x+i)*GRID_SIZE-GRID_SIZE/2, (y+j)*GRID_SIZE-GRID_SIZE/2);
            }
        }

    }

    /**
     * Makes level number 1
     */
    public void level_1_Create()
    {
        eaglePlace();
        makeWall(1,2,2,1,5);
        makeWall(1,7,2,3,4);
        makeWall(1,2,12,1,2);
        makeWall(1,19,3,1,4);
        makeWall(1,21,6,1,1);
        makeWall(1,14,4,4,2);
        makeWall(1,14,6,2,3);
        makeWall(1,14,9,4,2);
        makeWall(1,18,11,1,1);
        makeWall(1,20,10,1,5);
        makeWall(1,3,11,2,8);
        makeWall(1,6,9,4,1);
        makeWall(1,7,11,2,4);
        makeWall(1,9,13,2,2);
        makeWall(1,11,11,2,4);
        makeWall(1,18,18,4,1);
        makeWall(1,15,14,2,1);
        makeWall(1,18,14,2,1);
        makeWall(2,5,2,1,3);
        makeWall(2,13,3,2,1);
        makeWall(2,20,5,1,1);
        makeWall(2,1,10,2,1);
        makeWall(2,15,11,2,1);
        makeWall(3,6,2,1,1);
        makeWall(3,10,4,2,1);
        makeWall(3,5,10,3,1);
        makeWall(3,12,10,2,1);
        makeWall(3,18,2,3,1);
        makeWall(3,20,7,1,1);
        makeWall(3,17,14,4,1);
        makeWall(3,20,16,2,1);
        eToKillPlace(eLives);
        pToLivePlace(pLives);
        addObject(new Genemy(), GRID_SIZE/2, GRID_SIZE/2);
        addObject(new Genemy(), 10*GRID_SIZE, GRID_SIZE/2);
        addObject(new Penemy(), 20*GRID_SIZE, GRID_SIZE/2);
        addObject(new Player(), getWidth()/2-100, 18*GRID_SIZE-5);
    }

    /**
     * Makes level number 2
     */
    public void level_2_Create()
    {
        eaglePlace();
        eLives = 10;
        pLives = 3;
        eToKillPlace(eLives);
        pToLivePlace(pLives);
        makeWall(1, 9, 1, 1, 2);
        makeWall(1, 14, 1, 1, 1);
        makeWall(1, 2, 3, 4, 1);
        makeWall(1, 7, 3, 1, 1);
        makeWall(1, 10, 3, 3, 1);
        makeWall(1, 16, 3, 4, 1);
        makeWall(1, 17, 4, 1, 1);
        makeWall(1, 19, 4, 1, 1);
        makeWall(1, 5, 6, 1, 1);
        makeWall(1, 12, 5, 2, 4);
        makeWall(1, 10, 8, 2, 3);
        makeWall(1, 2, 8, 1, 1);
        makeWall(1, 4, 11, 3, 1);
        makeWall(1, 4, 12, 1, 1);
        makeWall(1, 4, 13, 1, 1);
        makeWall(1, 9, 12, 1, 1);
        makeWall(1, 14, 12, 1, 1);
        makeWall(1, 20, 10, 1, 5);
        makeWall(1, 19, 14, 1, 4);
        makeWall(1, 20, 16, 1, 2);
        makeWall(1, 14, 17, 1, 1);
        makeWall(1, 4, 17, 2, 2);
        makeWall(2, 11, 4, 3, 1);
        makeWall(2, 16, 5, 2, 1);
        makeWall(2, 15, 6, 4, 1);
        makeWall(2, 22, 7, 1, 1);
        makeWall(2, 8, 9, 1, 1);
        makeWall(2, 1, 10, 2, 1);
        makeWall(2, 5, 10, 5, 1);
        makeWall(2, 12, 12, 2, 2);
        makeWall(2, 15, 15, 4, 1);
        makeWall(3, 3, 1, 1, 1);
        makeWall(3, 4, 1, 1, 1);
        makeWall(3, 6, 3, 1, 3);
        makeWall(3, 7, 4, 5, 1);
        makeWall(3, 8, 5, 3, 3);
        makeWall(3, 20, 4, 2, 2);
        makeWall(3, 21, 9, 2, 4);
        makeWall(3, 7, 12, 2, 3);
        makeWall(3, 2, 13, 2, 3);
        makeWall(4,2,5,2,1);
        makeWall(4,4,7,3,2);
        makeWall(4,16,7,1,5);
        makeWall(4,15,10,1,1);
        makeWall(4,17,11,3,3);
        makeWall(4,16,16,1,2);

        addObject(new Senemy(), GRID_SIZE/2, GRID_SIZE/2);
        addObject(new Genemy(), 10*GRID_SIZE, GRID_SIZE/2);
        addObject(new Penemy(), 20*GRID_SIZE, GRID_SIZE/2);
        addObject(new Player(), getWidth()/2-100, 18*GRID_SIZE-5);
    }

    /**
     * Adds water to given grid locations
     */
    /*public void addWater(int x, int y, int xlength, int ylength)
    {
    for(int i = 0; i < xlength; i++)
    {
    for(int j = 0; i < ylength; j++)
    {
    addObject(new Water(), GRID_SIZE*(x+i)+GRID_SIZE/2, GRID_SIZE*(y+j)+GRID_SIZE/2);
    }
    }
    }*/

    /**
     * tells world to tell counter to add score
     */
    public void addScoreW(int points)
    {
        counter.addScore(points);
    }

    /**
     * Makes protective steel around eagle when the Eagle Protect power-up is picked up
     */
    public void eagleProtect()
    {
        int x = getWidth()/2 -40;
        int y = getHeight();
        addObject(new Steel(true), x - 40, y - 8);
        addObject(new Steel(true), x - 40, y - 24);
        addObject(new Steel(true), x - 40, y - 40);
        addObject(new Steel(true), x - 40, y - 56);
        addObject(new Steel(true), x - 24, y - 56);
        addObject(new Steel(true), x - 8,y - 56);
        addObject(new Steel(true), x + 8,y - 56);
        addObject(new Steel(true), x + 24,y - 56);
        addObject(new Steel(true), x + 40, y - 56);
        addObject(new Steel(true), x + 40, y - 40);
        addObject(new Steel(true), x + 40,y - 24);
        addObject(new Steel(true), x + 40,y - 8);
    }

    /**
     * Spawns new power-up
     */
    public void spawnPowerup()
    {
        int random = Greenfoot.getRandomNumber(3);
        int x = Greenfoot.getRandomNumber(getWidth()-80);
        int y = Greenfoot.getRandomNumber(getHeight()-56);
        if(random == 0) addObject(new Grenade(), x, y);
        else if(random == 1) addObject(new Time_Power(), x, y);
        else addObject(new Eagle_Protect(), x, y);
    }

    /**
     * Respawns Player life
     */
    public void respawnPlayer()
    {
        counter.playerRespawnCounter = 1;
    }

    /**
     * Changes the world to the next level
     */
    public void nextLevel()
    {

        level++;

        if(level>2)
        {
            addObject(new Winner(), getWidth()/2-40, getHeight()/2);
            Greenfoot.stop();
        }
        else
        {
            Stage_Cleared stage = new Stage_Cleared(level);
            addObject(stage, getHeight()/2, getWidth()/2);
        }
    }

}
