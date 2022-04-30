import greenfoot.*;
import java.util.List;

public class Earth extends Planet {
    List<HealthPieceEarth> health_pieces_earth = null;
    int health = 100;
    int prev_health = health;
    boolean f = true;

    public Earth() {
        super(new GifImage("earth-large.gif"));
    }
    
    public void act() {
        super.act();
        if (f) {
            getWorld().removeObjects(getWorld().getObjects(HealthPieceEarth.class));
            health_pieces_earth = getWorld().getObjects(HealthPieceEarth.class);
            for (int i=0; i<100; i++) {
                getWorld().addObject(new HealthPieceEarth(), 540 + i*2, 265);
            }
            health_pieces_earth = getWorld().getObjects(HealthPieceEarth.class);
            f = false;
        }
        if (isTouching(Enemy.class)) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            removeTouching(Enemy.class);
            health -= 20;
        }
        if (health != prev_health) {
            if (health != 0) {
                for (int i=0; i<prev_health-health; i++) {
                    HealthPieceEarth h = health_pieces_earth.get(i);
                    getWorld().removeObject(h);
                }
                health_pieces_earth = getWorld().getObjects(HealthPieceEarth.class);
                prev_health = health;
            }
        }
        if (health == 0) {
            Greenfoot.stop();
        }
    }
}