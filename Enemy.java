import greenfoot.*;

public class Enemy extends Actor {
    Player player = null;
    int move_cooldown, const_move_cooldown;
    public static int step = 2;
    int image_cooldown = 50;
    boolean f = true;

    public void act() {
        if (f) {
            player = getWorld().getObjects(Player.class).get(0);
            move_cooldown = Greenfoot.getRandomNumber(3) + 2;
            const_move_cooldown = move_cooldown;
            f = false;
        }
        move_cooldown--;
        if (move_cooldown == 0) {
            if (player.getX() - 5 > getX()) {
                setLocation(getX() + step, getY());
            } else if (player.getX() + 5 < getX()) {
                setLocation(getX() - step, getY());
            }
            if (player.getY() - 5 > getY()) {
                setLocation(getX(), getY() + step);
            } else if (player.getY() + 5 < getY()) {
                setLocation(getX(), getY() - step);
            }
            move_cooldown = const_move_cooldown;
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
