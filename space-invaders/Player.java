import greenfoot.*;
import java.util.List;

public class Player extends Actor {
    List<Star> stars = null;
    List<Enemy> enemies = null;
    List<Explosion> explosions = null;
    List<HealthPiece> health_pieces = null;
    List<Bullet> bullets = null;

    Boolean f = true;
    int step = 1;
    int hit_cooldown = 50;
    Boolean is_hit = false;
    int health = 100;
    int prev_health = health;
    Boolean is_lost = false;
    int lost_cooldown = 150;

    public void reset_health() {
        for (int i=0; i<100; i++) {
            getWorld().addObject(new HealthPiece(), 1080 + i*2, 30);
        }
        health_pieces = getWorld().getObjects(HealthPiece.class);
        health = 100;
        prev_health = health;
        lost_cooldown = 150;
    }
    
    public void act() {
        if (f) {
            stars = getWorld().getObjects(Star.class);
            health_pieces = getWorld().getObjects(HealthPiece.class);
            f = false;
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        enemies = getWorld().getObjects(Enemy.class);
        explosions = getWorld().getObjects(Explosion.class);
        bullets = getWorld().getObjects(Bullet.class);
        if (mouse != null && !is_lost) {
            turnTowards(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.isKeyDown("w") && !is_lost) {
            setLocation(getX(), getY() - step);
            for (Star s : stars) {
                s.setLocation(s.getX(), s.getY() + s.step);
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX(), e.getY() + e.step);
            }
            for (Explosion x : explosions) {
                x.setLocation(x.getX(), x.getY() + Enemy.step);
            }
            for (Bullet b : bullets) {
                b.setLocation(b.getX(), b.getY() + Enemy.step);
            }
        }
        if (Greenfoot.isKeyDown("s") && !is_lost) {
            setLocation(getX(), getY() + step);
            for (Star s : stars) {
                s.setLocation(s.getX(), s.getY() - s.step);
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX(), e.getY() - e.step);
            }
            for (Explosion x : explosions) {
                x.setLocation(x.getX(), x.getY() - Enemy.step);
            }
            for (Bullet b : bullets) {
                b.setLocation(b.getX(), b.getY() - Enemy.step);
            }
        }
        if (Greenfoot.isKeyDown("a") && !is_lost) {
            setLocation(getX() - step, getY());
            for (Star s : stars) {
                s.setLocation(s.getX() + s.step, s.getY());
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX() + e.step, e.getY());
            }
            for (Explosion x : explosions) {
                x.setLocation(x.getX() + Enemy.step, x.getY());
            }
            for (Bullet b : bullets) {
                b.setLocation(b.getX() + Enemy.step, b.getY());
            }
        }
        if (Greenfoot.isKeyDown("d") && !is_lost) {
            setLocation(getX() + step, getY());
            for (Star s : stars) {
                s.setLocation(s.getX() - s.step + 1, s.getY());
            }
            for (Enemy e : enemies) {
                e.setLocation(e.getX() - e.step, e.getY());
            }
            for (Explosion x : explosions) {
                x.setLocation(x.getX() - Enemy.step, x.getY());
            }
            for (Bullet b : bullets) {
                b.setLocation(b.getX() - Enemy.step, b.getY());
            }
        }
        if (Greenfoot.mouseClicked(null) && !is_lost) {
            Bullet b = new Bullet();
            getWorld().addObject(b, getX(), getY());
            b.setRotation(getRotation());
        }
        if (isTouching(Enemy.class) && !is_lost) {
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            getWorld().addObject(new EnemyExplosion(), e.getX(), e.getY());
            removeTouching(Enemy.class);
            health-=20;
            is_hit = true;
        }
        if (is_hit && !is_lost) {
            if (hit_cooldown == 50 || hit_cooldown == 25 || hit_cooldown == 0) {
                setImage("spaceship_hit.png");
            } else if (hit_cooldown == 36 || hit_cooldown == 12) {
                setImage("spaceship.png");
            }
            hit_cooldown--;
            if (hit_cooldown == 0) {
                setImage("spaceship.png");
                is_hit = false;
                hit_cooldown = 50;
            }
        }
        if (health != prev_health) {
            if (health != 0) {
                for (int i=0; i<prev_health-health; i++) {
                    HealthPiece h = health_pieces.get(i);
                    getWorld().removeObject(h);
                }
                health_pieces = getWorld().getObjects(HealthPiece.class);
                prev_health = health;
            }
        }
        if (health == 0 && !is_lost) {
            for (HealthPiece h : health_pieces) {
                getWorld().removeObject(h);
            }
            health_pieces = null;
            is_lost = true;
        }
        if (is_lost) {
            if (lost_cooldown == 150) {
                setImage("explosion_blue_01.png");
            } else if (lost_cooldown == 100) {
                setImage("explosion_blue_02.png");
            } else if (lost_cooldown == 75) {
                setImage("explosion_blue_03.png");
            } else if (lost_cooldown == 50) {
                setImage("explosion_blue_04.png");
            } else if (lost_cooldown == 0) {
                setImage("spaceship.png");
                reset_health();
                is_lost = false;
            }
            lost_cooldown--;
        }
    }
}