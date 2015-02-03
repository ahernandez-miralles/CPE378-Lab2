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
    private ArrayList<CollisionActor> allCollisionActors;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1, false); 
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
        test2object test2 = new test2object();
        addObject(land, 450, 250);
        //addObject(test, 400, 250);
        addObject(test2, 400, 250);
    }
}