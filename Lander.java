import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Lander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Lander extends AnimatedActor
{
    private GreenfootSound landSound, engineSound;
    public Lander(){
        super("images/placeholder", ".png", 6, 2);
    }
    /**
     * Act - do whatever the Lander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        ArrayList<CollisionActor> others = ((GameWorld)(getWorld())).getCollisionActors();
        //System.out.println(others);
        for (CollisionActor other : others) {
            //  System.out.println(other);
            if (this.intersects(other))
            {
                //if (other.getClass().equals(testobject.class)){
                    if(Math.abs(((GameWorld)(getWorld())).vx) > 2 
                    || ((GameWorld)(getWorld())).vy < -4 
                    || ((GameWorld)(getWorld())).vy > 0)
                    {
                        System.out.println("CRASH - TOO FAST");
                    }
                    else if (getY() > other.getY()) {
                        System.out.println("CRASH - TOO LOW");
                    }
                    else{
                        ((GameWorld)(getWorld())).setYVel(0);
                        ((GameWorld)(getWorld())).setXVel(0);
                        ((GameWorld)(getWorld())).landed = true;
                    }
                //}
            }
        }
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
        {
            ((GameWorld)(getWorld())).landed = false;
            ((GameWorld)getWorld()).addYVel(0.4);
        }
        if ((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) && !((GameWorld)(getWorld())).landed)
        {
            ((GameWorld)getWorld()).addXVel(0.2);
        }
        if ((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) && !((GameWorld)(getWorld())).landed)
        {
            ((GameWorld)getWorld()).addXVel(-0.2);
        }
        super.act();
    }    
}
