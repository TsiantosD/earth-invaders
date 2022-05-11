import greenfoot.*;

public class PlayButton extends MenuButton {
    int image_cooldown = 80;

    public void act() {
        if (image_cooldown == 80) {
            setImage("play_down.png");
        } else if (image_cooldown == 40) {
            setImage("play_up.png");
        } else if (image_cooldown == 0) {
            image_cooldown = 81;
        }
        image_cooldown--;
        if (isTouching(Bullet.class)) {
            Main w = new Main();
            getWorld().removeObject(this);
            // PlayerMenu pm = getWorld().getObjects(PlayerMenu.class).get(0);
            // getWorld().removeObject(pm);
            Greenfoot.setWorld(w);
        }
    }
}