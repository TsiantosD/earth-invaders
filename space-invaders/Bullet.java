import greenfoot.*;

public class Bullet extends Actor {
    public void act() {
        move(8);
        if (isTouching(Enemy.class)) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            removeTouching(Enemy.class);
            getWorld().removeObject(this);
        } else if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}