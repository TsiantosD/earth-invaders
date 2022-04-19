import greenfoot.*;
import java.util.List;

public class Player extends Actor {
    List<Star> stars = null;
    List<Enemy> enemies = null;
    Boolean f = true;
    int step = 1;

    public void act() {
        if (f) {
            stars = getWorld().getObjects(Star.class);
            f = false;
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        enemies = getWorld().getObjects(Enemy.class);
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - step);
            for (Star s : stars) {
                s.setLocation(s.getX(), s.getY() + s.step);
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX(), e.getY() + 1);
            }
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + step);
            for (Star s : stars) {
                s.setLocation(s.getX(), s.getY() - s.step);
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX(), e.getY() - 1);
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - step, getY());
            for (Star s : stars) {
                s.setLocation(s.getX() + s.step, s.getY());
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX() + 1, e.getY());
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + step, getY());
            for (Star s : stars) {
                s.setLocation(s.getX() - s.step, s.getY());
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX() - 1, e.getY());
            }
        }
        if (Greenfoot.mouseClicked(null)) {
            World world = (Main)getWorld();
            Bullet b = new Bullet();
            world.addObject(b, getX(), getY());
            b.setRotation(getRotation());
        }
    }
}