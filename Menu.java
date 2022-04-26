import greenfoot.*;

public class Menu extends Space {
    public Menu() {
        addObject(new PlayButton(), 1280/2, 720/4);
        addObject(new PlayerMenu(), 1280/2, (720/4)*3);
    }
}