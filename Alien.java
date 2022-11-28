import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Movable
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int type;
    private int speed = 2;
    private boolean isAbnormal;
    private Random random;
    
    public void act()
    {   
        if (isAbnormal) tektok();
        moveVertical(Math.abs(speed));
        returnToTop();
        dieIfHitByBullet();
    }
    
    public Alien() {
        type = Greenfoot.getRandomNumber(5);
        setImage("Alien" + type + ".png");
        random = new Random();
        
        isAbnormal = random.nextBoolean();
    }
    
    public void tektok() {
        if (getX() == getWorld().getWidth() - 1){
            speed = -speed;
        }
        
        else if (getX() == 0) {
            speed = Math.abs(speed);
        }
        
        moveHorizontal(speed);
    }
    
    public void returnToTop() {
        if (getY() == getWorld().getHeight() - 1) {
            setLocation(getX(), 0);
        }
    }
    
    public void dieIfHitByBullet(){
        if (isTouching(Bullet.class)) {
            Bullet bullet = getIntersectingObjects(Bullet.class).get(0);
            getWorld().removeObject(bullet);
            
            Explosion expl = new Explosion();
            getWorld().addObject(expl, getX(), getY());
            Greenfoot.playSound("sounds/blast.wav");
            
            MyWorld.counterScore.add(10);
            getWorld().addObject(new Alien(), Greenfoot.getRandomNumber(getWorld().getWidth() / 2), 0);
            
            disappear();
            return;
        }
    }
}
