import greenfoot.*;

public class HealthPiece extends Actor {
    int abs_x;
    int abs_y;
    boolean f = true;

    public void changePos(int x, int y) {
        abs_x += x;
        abs_y += y;
    }

    public void act() {
        if (f) {
            abs_x = getX();
            abs_y = getY();
            f = false;
        }
        if (abs_x <= 0 || abs_x >= 1280) {
            setImage((GreenfootImage)null);
        } else if (abs_y <= 0 || abs_y >= 720) {
            setImage((GreenfootImage)null);
        } else {
            setImage("health_01.png");
            setLocation(abs_x, abs_y);
        }
    }
}