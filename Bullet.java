import greenfoot.*;

public class Bullet extends Actor {
    public void act() {
        move(8);
        if (isTouching(Enemy.class)) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            if (e.image_choice == 0) {
                getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            } else {
                getWorld().addObject(new EnemyExplosion2(), e.getX(), e.getY());
            }
            removeTouching(Enemy.class);
            getWorld().removeObject(this);
        } else if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}