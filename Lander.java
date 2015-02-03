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
        super("pig_ship_", ".png", 1, 2);
    }
    /**
     * Act - do whatever the Lander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private void killPlayer() {
        ((GameWorld)(getWorld())).setYVel(0);
        ((GameWorld)(getWorld())).setXVel(0);
        ((GameWorld)(getWorld())).landed = true;
        getWorld().removeObject(this);
    }
    
    public void act() 
    {
        ArrayList<CollisionActor> others = ((GameWorld)(getWorld())).getCollisionActors();
        //System.out.println(others);
        for (CollisionActor other : others) {
            //  System.out.println(other);
            if (this.intersects(other))
            {
                if (other.getClass().equals(test2object.class)){
                    if(Math.abs(((GameWorld)(getWorld())).vx) > 2 
                    || ((GameWorld)(getWorld())).vy < -4 
                    || ((GameWorld)(getWorld())).vy > 0.5)
                    {
                        System.out.println("CRASH - TOO FAST");
                        killPlayer();
                    }
                    else if (getY() > other.getY()) {
                        System.out.println("CRASH - TOO LOW");
                        killPlayer();
                    }
                    else{
                        ((GameWorld)(getWorld())).setYVel(0);
                        ((GameWorld)(getWorld())).setXVel(0);
                        ((GameWorld)(getWorld())).landed = true;
                    }
                }
                else{
                    System.out.println("YOU HAVE CRASHED!");
                    killPlayer();
                    
                    
                }
            }
        }
        if (getWorld() != null) {
            if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                ((GameWorld)(getWorld())).landed = false;
                ((GameWorld)getWorld()).addYVel(0.4);
                Exhaust e1 = new Exhaust(-(int)((GameWorld)(getWorld())).getCamX() + 420, -(int)((GameWorld)(getWorld())).getCamY() + 280,"lander_trail_", ".png", 8, 2);
                getWorld().addObject(e1, 0, 0);
                Exhaust e2 = new Exhaust(-(int)((GameWorld)(getWorld())).getCamX() + 480, -(int)((GameWorld)(getWorld())).getCamY() + 280,"lander_trail_", ".png", 8, 2);
                getWorld().addObject(e2, 0, 0);
                ((GameWorld)(getWorld())).useFuel();
            }
            if ((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) && !((GameWorld)(getWorld())).landed && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                ((GameWorld)getWorld()).addXVel(0.2);
                ((GameWorld)(getWorld())).useFuel();
            }
            if ((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) && !((GameWorld)(getWorld())).landed && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                ((GameWorld)getWorld()).addXVel(-0.2);
                ((GameWorld)(getWorld())).useFuel();
            }
            super.act();
        }
    }    
}
