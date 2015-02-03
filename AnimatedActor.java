import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedActor extends Actor
{
    public enum AnimationState
    {
        ANIMATING, FROZEN, RESTING, SPECIAL;
    }
    protected GreenfootImage[] images = null;
    protected GreenfootImage specialImage = null;
    protected int currentImage = 0;
    private int animationCounter = 0;
    private int delay = 0;
    private AnimationState state;
    
    public AnimatedActor()
    {
        super();
        state = AnimationState.FROZEN;
    }
    public AnimatedActor(String basename, String suffix, int numImages, int delay)
    {
        super();
        
        images = new GreenfootImage[numImages];
        for (int i = 0; i < numImages; i++) {
            images[i] = new GreenfootImage(basename + i + suffix);
        }
        setImage(images[currentImage]);
        this.delay = delay;
        this.state = AnimationState.ANIMATING;
    }
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (images != null)
        {
            if (state == AnimationState.ANIMATING)
            {
                if(animationCounter++ > delay)
                {
                    animationCounter = 0;
                    currentImage = (currentImage + 1) % images.length;
                    setImage(images[currentImage]);
                }
            }
            else if (state == AnimationState.SPECIAL)
            {
                setImage(specialImage);
            }
            else if (state == AnimationState.RESTING)
            {
                state = AnimationState.FROZEN;
                animationCounter = 0;
                currentImage = 0;
                setImage(images[0]);
            }
        }
    }
    
    protected void useSpecialImage(GreenfootImage image)
    {
        this.specialImage = image;
        state = AnimationState.SPECIAL;
    }
    
    protected void animate()
    {
        state = AnimationState.ANIMATING;
    }
    
    protected void rest()
    {
        state = AnimationState.RESTING;
    }
    
    protected boolean isAnimating()
    {
        return state == AnimationState.ANIMATING;
    }
    
}
