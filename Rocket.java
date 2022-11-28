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
    
    public void shoot () {
        bulletTimer++;
        if (bulletTimer == 62) {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            
            bulletTimer = 0;
        }
    }
}
