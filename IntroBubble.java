import greenfoot.*;

/**
 * Write a description of class IntroBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroBubble extends ScrollingActor
{
    /**
     * Act - do whatever the IntroBubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("enter")) {
            ((GameWorld) getWorld()).music = new GreenfootSound("music.wav");
            ((GameWorld) getWorld()).music.playLoop();
            getWorld().removeObject(this);
        }
    }    
}
