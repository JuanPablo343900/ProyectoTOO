import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int scrollX, scrollY;
    private Player player;
    private Enemy enemy;
    private Label deathMessage;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1, false); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player = new Player();
        addObject(player,600,300);
        enemy = new Enemy();
        addObject(enemy,900,500);
        scrollX = 0;
        scrollY = 0;
        Ground ground = new Ground();
        addObject(ground,400,540);
        Ground ground2 = new Ground();
        addObject(ground2,600,540);
        Ground ground3 = new Ground();
        addObject(ground3,700,540);
        Ground ground4 = new Ground();
        addObject(ground4,500,540);
        Ground ground5 = new Ground();
        addObject(ground5,800,540);
        Ground ground6 = new Ground();
        addObject(ground6,900,540);
        Ground ground7 = new Ground();
        addObject(ground7,1000,540);
        Ground ground8 = new Ground();
        addObject(ground8,1100,540);
        Ground ground9 = new Ground();
        addObject(ground9,300,540);
        Ground ground10 = new Ground();
        addObject(ground10,200,540);
        Ground ground11 = new Ground();
        addObject(ground11,100,540);
        enemy.setLocation(864,327);
        Left left = new Left();
        addObject(left,100,500);
        Left left2 = new Left();
        addObject(left2,100,400);
        Right right = new Right();
        addObject(right,1100,500);
        enemy.setLocation(800,300);
        Right right2 = new Right();
        addObject(right2,1100,400);
        Roof roof = new Roof();
        addObject(roof,600,200);
        Ground ground12 = new Ground();
        addObject(ground12,800,240);
        Ground ground13 = new Ground();
        addObject(ground13,400,240);
    }
    
    public void youDied(){
        deathMessage = new Label("You died", 10);
        addObject(deathMessage, 600, 500);
    }
    
    public void act() {
        scroll();
    }

    public void scroll() {
        int personajeX = getObjects(Player.class).get(0).getX();
        int personajeY = getObjects(Player.class).get(0).getY();

        if (personajeX < scrollX + getWidth()/2) {
            scrollX = personajeX - 100;
        } else if (personajeX > scrollX + getWidth()/2) {
            scrollX = personajeX - getWidth() + 100;
        }
        if (personajeY < scrollY + getHeight()/2) {
            scrollY = personajeY - 100;
        } else if (personajeY > scrollY + getHeight()/2) {
            scrollY = personajeY - getHeight() + 100;
        }

        for (Object objeto : getObjects(null)) {
            Actor actor = (Actor) objeto;
            int x = actor.getX() - scrollX;
            int y = actor.getY() - scrollY;
            actor.setLocation(x, y);
        }
    }
    
    public int getScrollX() {
        return scrollX;
    }

    public void setScrollX(int scrollX) {
        this.scrollX = scrollX;
    }

    public int getScrollY() {
        return scrollY;
    }

    public void setScrollY(int scrollY) {
        this.scrollY = scrollY;
    }
}
