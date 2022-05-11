import greenfoot.*;

public class Enemy extends Actor {
    Player player = null;
    int move_cooldown, const_move_cooldown;
    public static int step = 2;
    int image_cooldown = 50;
    boolean f = true;
    int image_choice = 0;

    int abs_x;
    int abs_y;

    public void changePos(int x, int y) {
        abs_x += x;
        abs_y += y;
    }

    public void act() {
        if (f) {
            player = getWorld().getObjects(Player.class).get(0);
            move_cooldown = Greenfoot.getRandomNumber(2) + 1;
            const_move_cooldown = move_cooldown;
            abs_x = getX();
            abs_y = getY();
            f = false;
            image_choice = Greenfoot.getRandomNumber(2);
        }
        if (abs_x <= 0 || abs_x >= 1280) {
            setImage((GreenfootImage)null);
        } else if (abs_y <= 0 || abs_y >= 720) {
            setImage((GreenfootImage)null);
        } else {
            if (image_cooldown == 50) {
                if (image_choice == 0) {
                    setImage("enemy_down.png");
                } else {
                    setImage("enemy2_down.png");
                }
            } else if (image_cooldown == 25) {
                if (image_choice == 0) {
                    setImage("enemy_up.png");
                } else {
                    setImage("enemy2_up.png");
                }
            } else if (image_cooldown == 0) {
                image_cooldown = 51;
            }
            image_cooldown--;
            setLocation(abs_x, abs_y);
        }
        move_cooldown--;
        if (move_cooldown == 0) {
            if (player.getX() - 5 > getX()) {
                setLocation(getX() + step, getY());
                changePos(step, 0);
            } else if (player.getX() + 5 < getX()) {
                setLocation(getX() - step, getY());
                changePos(-step, 0);
            }
            if (player.getY() - 5 > getY()) {
                setLocation(getX(), getY() + step);
                changePos(0, step);
            } else if (player.getY() + 5 < getY()) {
                setLocation(getX(), getY() - step);
                changePos(0, -step);
            }
            move_cooldown = const_move_cooldown;
        }
    }
}