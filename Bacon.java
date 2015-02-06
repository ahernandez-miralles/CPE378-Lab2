import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bacon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bacon extends ScrollingActor
{
    /**
     * Act - do whatever the Bacon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double vx;
    private double vy;
    public Bacon(int x, int y, double vx, double vy)
    {
        super(x, y);
        this.vx = vx;
        this.vy = vy;
    }
    public void act() 
    {
        super.act();
        vy += 0.05;
        xoff += vx;
        yoff += vy;
    }    
}
