import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Block extends Actor
{
    protected boolean isGround = false;
    protected boolean isLeft = false;
    protected boolean isRight = false;
    protected boolean isRoof = false;
    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
    }
    
    //Setters
    public void isGround(){
        this.isGround = true;
    }
    public void isLeft(){
        this.isLeft = true;
    }
    public void isRight(){
        this.isRight = true;
    }
    public void isRoof(){
        this.isRoof = true;
    }
    
    //Getters
    public boolean checkIfGround(){
        return this.isGround;
    }
    
    public boolean checkIfLeft(){
        return this.isLeft;
    }
    
    public boolean checkIfRight(){
        return this.isRight;
    }
    
    public boolean checkIfRoof(){
        return this.isRoof;
    }
}
