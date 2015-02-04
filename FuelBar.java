import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class FuelBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FuelBar extends Actor
{
    /**
     * Act - do whatever the FuelBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage(110, 20);
    public FuelBar() {
        super();
    }
    public void act() 
    {
        
        image.setColor(Color.RED);
        image.fillRect(0, 0, 110, 20);
        image.setColor(Color.BLUE);
        image.fillRect(5, 2, ((GameWorld)(getWorld())).getFuel() / 5, 16);
        setImage(image);
    }    
}
