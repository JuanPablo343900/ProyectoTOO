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
        Floor floor = new Floor(1);
        addObject(floor,600,800);
        enemy = new Enemy();
        addObject(enemy,900,500);
        Floor floor2 = new Floor(2);
        addObject(floor2,100, 300);
        floor2.setRotation(90);
        Floor floor3 = new Floor(3);
        addObject(floor3,1100, 300);
        floor3.setRotation(90);
        scrollX = 0;
        scrollY = 0;
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
