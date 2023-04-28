import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    //Attributes
    private int verticalSpeed = 0;
    private int gravity = 1;
    private int horizontalSpeed = 0;
    private boolean inGround;
    private boolean harmful;
    private SimpleTimer killTime = new SimpleTimer();
    private SimpleTimer deathTime = new SimpleTimer();
    private GreenfootSound jumpSound = new GreenfootSound("Mario jump.mp3");
    private GreenfootSound deathMusic = new GreenfootSound("YOU DIED.mp3");
    private GreenfootSound spinSound = new GreenfootSound("Spin.mp3");
    private GreenfootSound deathSound;
    private World w;
    private Label deathMessage;
    private boolean dead = false;
    private boolean canDoubleJump = true;
    private SimpleTimer doubleJumpTimer = new SimpleTimer();
    private boolean isIdle;
    private boolean isRight = true;
    GifImage idleGif = new GifImage("Idle.gif");
    GifImage attackGif = new GifImage("Attack.gif");
    GreenfootImage actualSprite;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public boolean getHarmful(){
        return harmful;
    }
    
    public void act()
    {
        if(!dead){
            control();
        }
        move();
        checkInGround();
        checkTimers();
        checkDeath();
        checkAnimations();
        checkSounds();
        waitRespawn();
        killsSomething();
        playerScroll();
    }
    
    public void playerScroll(){
        MyWorld mundo = (MyWorld) getWorld();
        if (mundo != null) {
            int x = getX();
            int y = getY();
            if (x < mundo.getScrollX() + 100) {
                mundo.setScrollX(x - 100);
            } else if (x > mundo.getScrollX() + mundo.getWidth() - 100) {
                mundo.setScrollX(x - mundo.getWidth() + 100);
            }
            if (y < mundo.getScrollY() + 100) {
                mundo.setScrollY(y - 100);
            } else if (y > mundo.getScrollY() + mundo.getHeight() - 100) {
                mundo.setScrollY(y - mundo.getHeight() + 100);
            }
        }
    }
    
    public void control(){
        if(Greenfoot.isKeyDown("down")){
            dive();
        }
        if(Greenfoot.isKeyDown("up")){
            jump();
        }
        if(Greenfoot.isKeyDown("left")){
            horizontalSpeed = -6;
        }
        if(Greenfoot.isKeyDown("right")){
            horizontalSpeed = 6;
        }
        if(Greenfoot.isKeyDown("space")){
            attack();
        }
        if(Greenfoot.isKeyDown("r")){
            die();
        }
    }
    
    public void move(){
        setLocation(this.getX() + horizontalSpeed, this.getY() + verticalSpeed);
        horizontalSpeed = 0;
        if(!inGround){
            verticalSpeed += gravity;
        }
    }
    
    public void jump(){
        if(inGround || canDoubleJump){
            jumpSound.stop();
            jumpSound.play();
            verticalSpeed = -12;
            if(canDoubleJump && doubleJumpTimer.millisElapsed() > 200 && !inGround)
                canDoubleJump = false;
        }
    }
    
    public void dive(){
        if(!inGround){
            verticalSpeed = 45;
        }
    }
    
    public void attack(){
        harmful = true;
        spinSound.play();
        killTime.mark();
    }
    
    public void killsSomething(){
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy != null && harmful && !enemy.isDead()){
            enemy.die();
        }
    }
    
    public void checkDeath(){
        if(isAtEdge()){
            die();
        }
    }
    
    public void die(){
        if(!dead){
            w = getWorld();
            playDead();
            spinSound.stop();
            deathMusic.play();
            youDied();
            waitRespawn();
            dead = true;
        }
    }
    
    public void checkAnimations(){
        if(verticalSpeed == 0)
        {
            actualSprite = new GreenfootImage(idleGif.getCurrentImage());
        }
        if(verticalSpeed > 0)
        {
            actualSprite = new GreenfootImage("Fall.png");
        }
        if(verticalSpeed < 0)
        {
            actualSprite = new GreenfootImage("Jump.png");
        }
        if(dead){
            actualSprite = new GreenfootImage("Dead.png");
        }
        if(harmful){
            actualSprite = new GreenfootImage(attackGif.getCurrentImage());
        }
        if(horizontalSpeed < 0 && isRight){
            turn(180);
            isRight = false;
        }
        if(horizontalSpeed > 0 && !isRight){
            turn(180);
            isRight = true;
        }
        setImage(actualSprite);
    }
    
    public void checkSounds(){
        if(!harmful && spinSound.isPlaying()){
            //spinSound.stop();
        }
    }
    
    public void youDied(){
        deathMessage = new Label("You died", 100);
        w.addObject(deathMessage, 600, 100);
        dead = true;
    }
    
    public void waitRespawn(){
        if(dead && Greenfoot.isKeyDown("space")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void isAlive(){
        dead = false;
    }
    
    public void playDead(){
        switch(Greenfoot.getRandomNumber(7)){
            case 1:
                deathSound = new GreenfootSound("Katana Zero death.mp3");
                break;
            case 2:
                deathSound = new GreenfootSound("Lego break.mp3");
                break;
            case 3:
                deathSound = new GreenfootSound("Undertale death.mp3");
                break;
            case 4:
                deathSound = new GreenfootSound("Minecraft death.mp3");
                break;
            case 5:
                deathSound = new GreenfootSound("Terraria death.mp3");
                break;
            case 6:
                deathSound = new GreenfootSound("leftfordeath.mp3");
                break;
            default:
                deathSound = new GreenfootSound("ouch.mp3");
                break;
        }
        deathSound.play();
    }
    
    public void checkInGround(){
        Actor floor = getOneIntersectingObject(Floor.class);
        if(floor != null){
            inGround = true;
            canDoubleJump = true;
            doubleJumpTimer.mark();
            verticalSpeed = 0;
            
        }else{
            inGround = false;
        }
    }
    
    public void checkTimers(){
        if(killTime.millisElapsed() > 400){
            harmful = false;
        }
        if(deathTime.millisElapsed() > 5000){
            //w.removeObject(deathMessage);
        }
    }
    
}
