import greenfoot.*;

public class Space extends World {
    public Space() {
        super(1280, 720, 1);
        for (int i=0; i<=50; i++) {
            addObject(new Star1(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            addObject(new Star2(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            addObject(new Star3(), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
        }
        // addObject(new Earth(), 400, 400);
        addObject(new Mars(), 1000, 200);
        setPaintOrder(
            Text.class, 
            Player.class, 
            PlayerMenu.class, 
            MenuButton.class, 
            Enemy.class, 
            Star1.class, 
            Planet.class, 
            Star2.class, 
            Star3.class
        );
    }
}