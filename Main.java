import greenfoot.*;
import java.util.List;

public class Main extends Space {
    List<Enemy> enemies = null;
    boolean spawn = true;
    boolean start = true;
    int level = 0;
    int spawn_cooldown = 100;
    int play_cooldown = 180;

    public Main() {
        addObject(new Player(), 640, 360);
    }
    public void spawnEnemies(int n) {
        if (n == 0)
            n = 1;
        int const_n = n;
        for (int j=0; j<const_n; j++) {
            if (n != 0) {
                addObject(new Enemy(), 80, Greenfoot.getRandomNumber(720));
                n--;
            }
            if (n != 0) {
                addObject(new Enemy(), 1200, Greenfoot.getRandomNumber(720));
                n--;
            }
            if (n != 0) {
                addObject(new Enemy(), Greenfoot.getRandomNumber(1280), 80);
                n--;
            }
            if (n != 0) {
                addObject(new Enemy(), Greenfoot.getRandomNumber(1280), 640);
                n--;
            }
        }
    }

    public void act() {
        // just entered game
        if (play_cooldown != 0) {
            if (start) {
                for (int i=0; i<100; i++) {
                    addObject(new HealthPieceEarth(), 540 + i*2, 265);
                }
                addObject(new CountDown(), 1280/2, 720/4);
                start = false;
            }
            play_cooldown--;
        } else {
            // game starts
            enemies = getObjects(Enemy.class);
            if (enemies.size() == 0) {
                spawn_cooldown--;
                if (spawn_cooldown == 0) {
                    spawn = true;
                    spawn_cooldown = 100;
                }
            }
            if (level == 10) {
                Greenfoot.stop();
            }
            if (spawn) {
                level++;
                spawnEnemies(level);
                spawn = false;
                showText("Level: " + level, 50, 20);
            }
        }
    }
}