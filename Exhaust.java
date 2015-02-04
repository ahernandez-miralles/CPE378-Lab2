import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exhaust here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exhaust extends ScrollingActor
{
    /**
     * Act - do whatever the Exhaust wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Exhaust(int x, int y, String s1, String s2, int frames, int delay)
    {
        super(x, y, s1, s2, frames, delay);
    }
    public void act() 
    {
        super.act();
        if (this.currentImage == this.images.length - 1){
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }    
}
