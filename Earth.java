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
            for (int i=0; i<5; i++) {
                getWorld().addObject(new HealthPieceEarth(), 560 + i*40, 265);
            }
            health_pieces_earth = getWorld().getObjects(HealthPieceEarth.class);
            f = false;
        }
        if (isTouching(Enemy.class)) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            if (e.image_choice == 0) {
                getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            } else {
                getWorld().addObject(new EnemyExplosion2(), e.getX(), e.getY());
            }
            removeTouching(Enemy.class);
            health -= 20;
        }
        if (health != prev_health) {
            if (health != 0) {
                HealthPieceEarth h = health_pieces_earth.get(0);
                getWorld().removeObject(h);
                health_pieces_earth = getWorld().getObjects(HealthPieceEarth.class);
                prev_health = health;
            }
        }
        if (health == 0) {
            getWorld().getObjects(Player.class).get(0).health = 0;
        }
    }
}