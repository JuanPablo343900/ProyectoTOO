import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    private boolean isGround = false;
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isRoof = false;
    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Floor(int mode){
        switch(mode){
            case 1:
                isGround = true;
                break;
            case 2:
                isLeft = true;
                break;
            case 3:
                isRight = true;
                break;
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public boolean checkIfGround(){
        return this.isGround;
    }
    
    public boolean checkIfLeft(){
        return this.isLeft;
    }
    
    public boolean checkIfRight(){
        return this.isRight;
    }
}
