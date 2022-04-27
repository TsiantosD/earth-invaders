import greenfoot.*;

public class Space extends World {
    int height = getHeight();
    int width = getWidth();

    public Space() {
        super(1280, 720, 1);

        for (int i=0; i<=50; i++) {
            addObject(new Star1(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            addObject(new Star2(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            addObject(new Star3(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
        }

        Planet e = new Earth();
        addObject(e, 1000, 500);
        e.changePos(1000, 500);

        Planet m = new Mars();
        addObject(m, 100, 200);
        m.changePos(100, 200);

        Planet s = new Saturn();
        addObject(s, 500, 700);
        s.changePos(500, 700);

        setPaintOrder(
            Text.class, 
            HealthPiece.class, 
            Player.class, 
            PlayerMenu.class, 
            Bullet.class, 
            MenuButton.class, 
            Enemy.class, 
            Explosion.class, 
            Star1.class, 
            Planet.class, 
            Star2.class, 
            Star3.class
        );
    }
}