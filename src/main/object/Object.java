package main.object;

import java.awt.image.BufferedImage;

import main.GamePanel;

public abstract class Object {
    
    public BufferedImage image;
    public boolean isSolid;
    
    abstract public void onColision(GamePanel gamePanel);
}
