import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Capitalist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitalist extends CollisionActor
{
    
    /**
     * Act - do whatever the Capitalist wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int behavior; //0 = back and forth, starting right, 1 = chase
    private int range; //for back and forth, number of frames going right, for chase, pixel distance to chase at.
    private int speed;
    private int curTime;
    public Capitalist(int x, int y, int behavior, int range, int speed){
        super(x, y, "dog_ship_", ".png", 2, 5);
        this.behavior = behavior;
        this.range = range;
        this.speed = speed;
        curTime = 0;
    }
    public void act() 
    {
        if (behavior == 0) 
        {
            if (curTime > range) {
                this.xoff += speed;
                this.useFlippedImage();
            }
            else
            {
                this.xoff -= speed;
                this.useDefaultImage();
            }
            curTime = curTime % (2 * range);
            curTime++;
        }
         if (behavior == 1) 
         {
             //System.out.println(Math.abs(xoff + ((GameWorld)(getWorld())).getCamX() - 450) + Math.abs(yoff + ((GameWorld)(getWorld())).getCamY() - 250));
             if (Math.abs(xoff + ((GameWorld)(getWorld())).getCamX() - 450) + Math.abs(yoff + ((GameWorld)(getWorld())).getCamY() - 250) <= range)
             {
                 if (xoff + ((GameWorld)(getWorld())).getCamX() - 450 > 5) 
                 {
                     xoff -= speed;
                     this.useDefaultImage();
                 }
                 
                 if (xoff + ((GameWorld)(getWorld())).getCamX() - 450 < -5) 
                 {
                     xoff += speed;
                     this.useFlippedImage();
                 }
                 
                 if (yoff + ((GameWorld)(getWorld())).getCamY() - 250 > 5) 
                 {
                     yoff -= speed;
                 }
                 
                 if (yoff + ((GameWorld)(getWorld())).getCamY() - 250 < -5) 
                 {
                     yoff += speed;
                 }
             }
         }
            
        super.act();
        // Add your action code here.
    }    
}
