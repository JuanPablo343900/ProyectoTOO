import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    //Attributes
    protected int verticalSpeed = 0;
    protected int gravity = 1;
    protected int horizontalSpeed = 0;
    protected boolean inGround;
    protected boolean harmful;
    protected boolean dead = false;
    GreenfootImage actualSprite;
    protected boolean isIdle;
    protected boolean isRight = true;
    protected boolean inWall = false;
    protected GreenfootSound deathSound;
    protected World w;
    
    //ACT
    public void act()
    {
        // Add your action code here.
    }
    
    //Getters
    public boolean getHarmful(){
        return harmful;
    }
    
    //Methods
    public void move(){
        setLocation(this.getX() + horizontalSpeed, this.getY() + verticalSpeed);
        horizontalSpeed = 0;
        
    }
    
    public void isAlive(){
        dead = false;
    }
    
    public void checkCollisions(){
        checkInGround();
        checkWalls();
        //checkRoof();
    }
    
    public void checkInGround(){
        Actor ground = getOneIntersectingObject(Ground.class);
        if(ground != null){
            inGround = true;
            verticalSpeed = 0;
        }else{
            inGround = false;
        }
    }
    
    public void checkWalls(){
        Actor left = getOneIntersectingObject(Left.class);
        if(left != null && horizontalSpeed < 0){
            horizontalSpeed = 0;
        }
        
        Actor right = getOneIntersectingObject(Right.class);
        if(right != null && horizontalSpeed > 0){
            horizontalSpeed = 0;
        }
        
    }
    
    public void checkRoof(){
        Actor roof = getOneIntersectingObject(Roof.class);
        if(roof != null && verticalSpeed < 0){
            verticalSpeed = 0;
        }
    }
}
