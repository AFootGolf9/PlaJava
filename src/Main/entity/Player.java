package Main.entity;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;
import Main.utility.ImagesUtil;

public class Player extends Entity{
    
    GamePanel gamePanel;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        setDefautValues();
        getPlayerImage();
    }

    public void setDefautValues() {
        worldX = gamePanel.tileSize * 2;
        worldY = gamePanel.tileSize * 7;
        speed = 4;
        state = "right";
    }
    public void getPlayerImage() {
        
        try{
            rigth1 = ImageIO.read(getClass().getResourceAsStream("/Player/Player-1-v0.1.png"));
            rigth2 = ImageIO.read(getClass().getResourceAsStream("/Player/Player-2-v0.1.png"));
            left1 = ImagesUtil.flipImageHorizontally(rigth1);
            left2 = ImagesUtil.flipImageHorizontally(rigth2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.upPressed || keyH.leftPressed || keyH.rightPressed || keyH.downPressed){
            spriteCounter++;
            if (spriteCounter >= 15) {
                spriteCounter = 0;
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
            }
        }

        if (keyH.upPressed) {
            //state = "jump";
            worldY -= speed;
        }
        if (keyH.downPressed) {
            worldY += speed;
        }
        if (keyH.leftPressed) {
            state = "left";
            worldX -= speed;
        }
        if (keyH.rightPressed) {
            state = "right";
            worldX += speed;
        }

        
    }

    public void draw(java.awt.Graphics2D g2) {
        
        BufferedImage image = null;

        if(spriteNum == 1){
            switch (state) {
                case "right":
                    image = rigth1;
                    break;
                case "left":
                    image = left1;
                    break;
            }
        }else if(spriteNum == 2){
            switch (state) {
                case "right":
                    image = rigth2;
                    break;
                case "left":
                    image = left2;
                    break;
            }
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
