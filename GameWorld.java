import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private double camX, camY;
    private int width, height;
    public double vx, vy;
    public boolean landed = false;
    private int fuel;
    private ArrayList<CollisionActor> allCollisionActors;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1, false); 
        fuel = 500;
        width = getWidth();
        height = getHeight();
        allCollisionActors = new ArrayList<CollisionActor>();
        vx = 0;
        vy = 0;
        camX = 0;
        camY = 0;
        placeActors();
    }
    public ArrayList<CollisionActor> getCollisionActors()
    {
        return allCollisionActors;
    }
    @Override
    public void act()
    {
        if (!landed) {
            vy -= 0.1;
        }
        camX += vx;
        camY += vy;
        System.out.println(fuel);
    }
    public void useFuel()
    {
        fuel--;
    }
    public void setFuel(int newFuel)
    {
        fuel = newFuel;
    }
    public int getFuel()
    {
        return fuel;
    }
    public double getCamX() {
        return camX;
    }
    public double getCamY() {
        return camY;
    }
    public void addXVel(double vx) {
        this.vx += vx;
    }
    public void addYVel(double vy) {
        this.vy += vy;
    }
    public void setXVel(double v) {
        this.vx = 0;
    }
    public void setYVel(double v) {
        this.vy = 0;
    }
    public void placeActors(){
        Lander land = new Lander();
        //testobject test = new testobject();
        Background bg = new Background();
        test2object test2 = new test2object();
        //CREATE ALL OBJECTS HERE
        //Constructor for platform: new (x, y)
        addObject(bg, 0, 0);
        //addObject(test, 400, 250);
        addObject(test2, 400, 250);
        //ADD ALL PLATFORMS HERE
        //THEN ADD ALL ENEMIES
        //THEN ADD FINISH?
        addObject(land, 450, 250);
    }
}
