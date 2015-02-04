import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CollisionActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionActor extends ScrollingActor
{
    public CollisionActor() //DON'T USE THIS!
    {
        super();
    }
    public CollisionActor(int x, int y) {
        super(x, y);
    }
    public CollisionActor(int x, int y, String basename, String suffix, int numImages, int delay)
    {   
        super(x, y, basename, suffix, numImages, delay);
    }
    protected void addedToWorld(World world)
    {
        ((GameWorld)world).getCollisionActors().add(this);
    }
    public void act()
    {
        super.act();
    }
}
