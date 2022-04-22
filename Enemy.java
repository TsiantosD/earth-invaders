import greenfoot.*;

public class Enemy extends Actor {
    Player p = null;
    public static int step = Greenfoot.getRandomNumber(3) + 1;
    int move_cooldown = 7;
    int image_cooldown = 50;
    boolean f = true;

    public void act() {
        if (f) {
            p = getWorld().getObjects(Player.class).get(0);
            f = false;
        }
        move_cooldown--;
        if (move_cooldown == 0) {
            if (p.getX() > getX()) {
                setLocation(getX() + 1, getY());
            } else if (p.getX() < getX()) {
                setLocation(getX() - 1, getY());
            }
            if (p.getY() > getY()) {
                setLocation(getX(), getY() + 1);
            } else if (p.getY() < getY()) {
                setLocation(getX(), getY() - 1);
            }
            move_cooldown = 2;
        }
        if (image_cooldown == 50) {
            setImage("enemy_down.png");
        } else if (image_cooldown == 25) {
            setImage("enemy_up.png");
        } else if (image_cooldown == 0) {
            image_cooldown = 51;
        }
        image_cooldown--;
    }
}
