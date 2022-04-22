import greenfoot.*;

public class PlayerMenu extends Actor {
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseClicked(null)) {
            Bullet b = new Bullet();
            getWorld().addObject(b, getX(), getY());
            b.setRotation(getRotation());
        }
    }
}
