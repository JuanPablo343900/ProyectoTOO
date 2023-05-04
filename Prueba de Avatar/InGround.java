import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InGround extends Entity
{
    /**
     * Act - do whatever the InGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    @Override
    public void move(){
        setLocation(this.getX() + horizontalSpeed, this.getY() + verticalSpeed);
        horizontalSpeed = 0;
        if(!inGround){
            verticalSpeed += gravity;
        }
    }
}
