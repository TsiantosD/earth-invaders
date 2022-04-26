import greenfoot.*;

public class Star extends Actor {
    protected int step;
    int cooldown = 4;
    public void act() {
        cooldown--;
        if (cooldown == 0) {
            move(-step);
            cooldown = 4;
        }
        if (getX() == 0) {
            setLocation(1278, getY());
        }
        else if (getX() == 1279) {
            setLocation(1, getY());
        }
        else if (getY() == 0) {
            setLocation(getX(), 718);
        }
        else if (getY() == 719) {
            setLocation(getX(), 1);
        }
    }
}