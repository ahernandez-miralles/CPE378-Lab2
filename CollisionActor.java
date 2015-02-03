import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CollisionActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionActor extends ScrollingActor
{
    /**
     * Act - do whatever the CollisionActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CollisionActor()
    {
        super();
    }
    
    public CollisionActor(int x, int y) {
        super(x, y);
    }
    
    public CollisionActor(String basename, String suffix, int numImages, int delay)
    {
        super(basename, suffix, numImages, delay);
    }
    public CollisionActor(int x, int y, String basename, String suffix, int numImages, int delay)
    {   
        super(x, y, basename, suffix, numImages, delay);
    }
    protected void addedToWorld(World world)
    {
        ((GameWorld)world).getCollisionActors().add(this);
    }
}
