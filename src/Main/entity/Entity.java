package Main.entity;

import java.awt.image.BufferedImage;

public class Entity {
    
    public int worldX, worldY;
    public int speed;

    public BufferedImage rigth1, rigth2, left1, left2;
    public String state;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
