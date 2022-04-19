import greenfoot.*;

public class Explosion extends Actor {
    String filename;
    public Explosion(String f) {
        filename = f;
    }
    int timer = 100;
    int timer_const = timer;
    public void act() {
        if (timer == timer_const) {
            setImage(filename + "_01.png");
        } else if (timer == (timer_const/4)*3) {
            setImage(filename + "_02.png");
        } else if (timer == timer_const/2) {
            setImage(filename + "_03.png");
        } else if (timer == timer_const/4) {
            setImage(filename + "_04.png");
        } else if (timer == 0) {
            getWorld().removeObject(this);
        }
        timer--;
    }
}
