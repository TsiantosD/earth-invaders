import greenfoot.*;

public class Earth extends Planet {
    GifImage gif_image = new GifImage("earth.gif");

    boolean f = true;

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
            setImage(gif_image.getCurrentImage());
        }
    }
}
