import greenfoot.*;

public class Planet extends Actor {
    protected int abs_x;
    protected int abs_y;

    public void changePos(int x, int y) {
        abs_x += x;
        abs_y += y;
        System.out.println(abs_x + " " + abs_y);
    }

    public Planet() {}

    public void act() {}
}