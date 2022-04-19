import greenfoot.*;

public class Parallax extends World {
    public Parallax() {
        super(1280, 720, 1);
        for (int i=0; i<=50; i++) {
            addObject(new Star1(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            addObject(new Star2(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            addObject(new Star3(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
        }
    }
}
