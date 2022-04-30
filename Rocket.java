import greenfoot.*;

public class Rocket extends Actor {
    int destroy_cooldown = 300;
    int mouse_x = 0;
    int mouse_y = 0;

    public void act() {
        move(3);
        // setRotation(getWorld().getObjects(Player.class).get(0).getRotation());
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            mouse_x = mouse.getX();
            mouse_y = mouse.getY();
        }
        turnTowards(mouse_x, mouse_y);
        if (isTouching(Enemy.class)) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            removeTouching(Enemy.class);
            getWorld().removeObject(this);
        } else if (isAtEdge() || destroy_cooldown == 0) {
            getWorld().removeObject(this);
        }
        destroy_cooldown--;
    }
}