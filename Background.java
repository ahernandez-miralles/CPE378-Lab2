import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends ScrollingActor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Background()
    {
        super();
        xoff = 450;
        yoff = 300;
    }
    public void act() 
    {
        super.act();
        setLocation(xoff + (int)((GameWorld)getWorld()).getCamX()/10, yoff + (int)((GameWorld)getWorld()).getCamY()/10 + 50);

    }    
}
