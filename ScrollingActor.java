import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingActor extends AnimatedActor
{
    private int xoff, yoff;
    public ScrollingActor()
    {
        super();
        xoff = 0;
        yoff = 0;
    }
    
    public ScrollingActor(int x, int y) {
        super();
        xoff = x;
        yoff = y;
    }
    
    public ScrollingActor(String basename, String suffix, int numImages, int delay)
    {
        super();
        xoff = 0;
        yoff = 0;
    }
    public ScrollingActor(int x, int y, String basename, String suffix, int numImages, int delay)
    {   
        super(basename, suffix, numImages, delay);
        xoff = x;
        yoff = y;
    }
    /**
     * Act - do whatever the ScrollingActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        setLocation(xoff + (int)((GameWorld)getWorld()).getCamX(), yoff + (int)((GameWorld)getWorld()).getCamY());
    }    
}
