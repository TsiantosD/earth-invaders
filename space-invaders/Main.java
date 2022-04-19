import greenfoot.*;
import java.util.List;

public class Main extends Parallax {
    List<Enemy> enemies = null;
    boolean spawn = true;
    int level = 1;
    int spawn_cooldown = 100;

    public Main() {
        addObject(new Player(), 640, 360);
    }

    public void spawnEnemies(int n) {
        for (int i=0; i<n/4; i++) {
            addObject(new Enemy(), 0, Greenfoot.getRandomNumber(720));
        }
        for (int i=0; i<n/4; i++) {
            addObject(new Enemy(), 1280, Greenfoot.getRandomNumber(720));
        }
        for (int i=0; i<n/4; i++) {
            addObject(new Enemy(), Greenfoot.getRandomNumber(1280), 0);
        }
        for (int i=0; i<n/4; i++) {
            addObject(new Enemy(), Greenfoot.getRandomNumber(1280), 720);
        }
    }

    public void act() {
        enemies = getObjects(Enemy.class);
        if (enemies.size() == 0) {
            spawn_cooldown--;
            if (spawn_cooldown == 0) {
                spawn = true;
                spawn_cooldown = 100;
            }
        }
        if (spawn) {
            spawnEnemies(4);
            spawn = false;
        }
    }
}