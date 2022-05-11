import greenfoot.*;

// Sound from Zapsplat.com
// Planet GIFs by: https://deep-fold.itch.io/pixel-planet-generator

public class Space extends World {
    int height = getHeight();
    int width = getWidth();

    public Space() {
        super(1280, 720, 1);

        for (int i=0; i<=25; i++) {
            addObject(new Star1(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            addObject(new Star2(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            addObject(new Star3(), Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
        }

        Planet e = new Earth();
        addObject(e, width/2, height/2);
        e.changePos(width/2, height/2);

        Planet m = new Mars();
        addObject(m, 100, 200);
        m.changePos(100, 200);

        Planet s = new Saturn();
        addObject(s, 500, 700);
        s.changePos(500, 700);
        
        Planet sun = new Sun();
        addObject(sun, 1180, 80);
        sun.changePos(1180, 80);
    
        setPaintOrder(
            Text.class, 
            HealthPiece.class, 
            Player.class, 
            PlayerMenu.class, 
            Bullet.class, 
            Rocket.class, 
            MenuButton.class, 
            Enemy.class, 
            Explosion.class, 
            Planet.class, 
            Star1.class, 
            Star2.class, 
            Star3.class
        );
    }
}