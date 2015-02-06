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
    private GreenfootSound landSound;
    private GreenfootSound engineSound = new GreenfootSound("sounds/jet_loop.wav");
    
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
        engineSound.stop();
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
                if (other.getClass().equals(Platform.class) || other.getClass().equals(FuelPlatform.class) || other.getClass().equals(WinPlatform.class)){
                    if(other.getClass().equals(WinPlatform.class)) {
                        System.out.println("YOU WIN");
                        killPlayer();
                    }
                    if(Math.abs(((GameWorld)(getWorld())).vx) > 2 
                    || ((GameWorld)(getWorld())).vy < -4 
                    || ((GameWorld)(getWorld())).vy > 0.5)
                    {
                        //crash due to too much X or Y velocity
                        System.out.println("CRASH - TOO FAST");
                        killPlayer();
                    }
                    else if (getY() > other.getY()) {
                        //crash because player impacted below the platform, or along the side of it
                        System.out.println("CRASH - TOO LOW");
                        killPlayer();
                    }
                    else{
                        ((GameWorld)(getWorld())).setYVel(0);
                        ((GameWorld)(getWorld())).setXVel(0);
                        ((GameWorld)(getWorld())).landed = true;
                        if (other.getClass().equals(FuelPlatform.class)) {
                            ((GameWorld)(getWorld())).addFuel();
                        }
                    }
                }
                else{
                    //crashed because it collided with an enemy or something that cannot be landed on.
                    System.out.println("YOU HAVE CRASHED!");
                    killPlayer();
                }
            }
        }
        if (getWorld() != null) {
            boolean keyDown = false;
            if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                keyDown = true;
                ((GameWorld)(getWorld())).landed = false; //no longer landed if applicable
                ((GameWorld)getWorld()).addYVel(0.4);
                //add the particles
                Exhaust e1 = new Exhaust(-(int)((GameWorld)(getWorld())).getCamX() + 420, -(int)((GameWorld)(getWorld())).getCamY() + 280,"lander_trail_", ".png", 8, 2);
                getWorld().addObject(e1, 420, 280);
                Exhaust e2 = new Exhaust(-(int)((GameWorld)(getWorld())).getCamX() + 480, -(int)((GameWorld)(getWorld())).getCamY() + 280,"lander_trail_", ".png", 8, 2);
                getWorld().addObject(e2, 480, 280);
                ((GameWorld)(getWorld())).useFuel();
                
            }
            if ((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) && !((GameWorld)(getWorld())).landed && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                keyDown = true;
                ((GameWorld)getWorld()).addXVel(0.2);
                ((GameWorld)(getWorld())).useFuel();
            }
            if ((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) && !((GameWorld)(getWorld())).landed && ((GameWorld)(getWorld())).getFuel() > 0)
            {
                keyDown = true;
                ((GameWorld)getWorld()).addXVel(-0.2);
                ((GameWorld)(getWorld())).useFuel();
            }
            if (!engineSound.isPlaying() && keyDown)
            {
                engineSound.playLoop();
            }
            if (!keyDown)
            {
                engineSound.stop();
            }
            if (((GameWorld)getWorld()).vx > 0)
            {
                this.useFlippedImage();
            }
            else {
                this.useDefaultImage();
            }
            super.act();
        }
    }    
}
