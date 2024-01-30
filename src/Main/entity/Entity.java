package Main.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int worldX, worldY;
    public int speedX, speedY,  maxSpeed;
    public int acceleration;

    public BufferedImage rigth1, rigth2, left1, left2;
    public String state;
    public String lastState;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public Boolean isSolid;
}
