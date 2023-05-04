import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Flying
{
    private GreenfootSound deathSound = new GreenfootSound("Undertale monster kill.mp3");
    private GreenfootSound victorySound = new GreenfootSound("a.mp3");
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //checkRemove();
        move();
    }
    
    public void die(){
        deathSound.play();
        setImage("skull.png");
        dead = true;
    }
    
    private void checkRemove(){
        Actor p = (Actor) getOneIntersectingObject(Player.class);
        if(p != null && !dead){
            die();
        }
    }
    
    public boolean isDead(){
        return dead;
    }
    
}
