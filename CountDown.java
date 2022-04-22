import greenfoot.*;

public class CountDown extends Text {
    int c = 180;
    public void act() {
        c--;
        if (c == 179) {
            setImage("3.png");
        } else if (c == 120) {
            setImage("2.png");
        } else if (c == 60) {
            setImage("1.png");
        } else if (c == 0) {
            getWorld().removeObject(this);
        }
    }
}
