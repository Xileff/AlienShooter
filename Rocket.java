import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Movable
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int bulletTimer = 0;
    
    public void act()
    {
        // Add your action code here.
        keyboardMovement();
        shoot();
        dieIfHitAlien();
    }
    
    public void keyboardMovement () {
        if (Greenfoot.isKeyDown("up")) {
            moveVertical(-speed);
        }
        
        else if (Greenfoot.isKeyDown("right")) {
            moveHorizontal(speed);
        }
        
        else if (Greenfoot.isKeyDown("down")) {
            moveVertical(speed);
        }
        
        else if (Greenfoot.isKeyDown("left")) {
            moveHorizontal(-speed);
        }
    }
    
    public void shoot() {
        bulletTimer++;
        if (bulletTimer == 62) {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            
            Greenfoot.playSound("sounds/ammo.wav");
            
            bulletTimer = 0;
        }
    }
    
    public void dieIfHitAlien() {
        if (isTouching(Alien.class)) {
            getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            
            Explosion expl = new Explosion();
            getWorld().addObject(expl, getX(), getY());
            Greenfoot.playSound("sounds/blast.wav");
            
            getWorld().removeObject(this);
            Greenfoot.stop();
            return;
        }
    }
}
