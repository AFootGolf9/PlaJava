package Main.entity;

import java.io.IOException;
import java.awt.Rectangle;
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

        int pixelValue = gamePanel.tileSize / 16;
        solidArea = new Rectangle(pixelValue, pixelValue , gamePanel.tileSize - pixelValue*2, gamePanel.tileSize - pixelValue*4);

        setDefautValues();
        getPlayerImage();
    }

    public void setDefautValues() {
        worldX = gamePanel.tileSize * 2;
        worldY = gamePanel.tileSize * 7;
        speedX = 0; speedY = 0;
        maxSpeed = 5;
        acceleration = 1;
        state = "right";
        lastState = "right";
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
        gravity();

        if(keyH.upPressed || keyH.leftPressed || keyH.rightPressed || keyH.downPressed){
            
            somethingIsPressed();

        }else{
            
        }

        if(speedX > 0){
            speedX -= acceleration;
        }else if(speedX < 0){
            speedX += acceleration;
        }

        if(!gamePanel.cCheker.checkTileX(this)){
            worldX += speedX;
        }else{
            speedX = 0;
        }

        if (!gamePanel.cCheker.checkTileY(this)) {
            worldY += speedY;
        }else{
            speedY = 0;
        }

        
    }

    public void draw(java.awt.Graphics2D g2) {
        
        BufferedImage image = null;

        if(spriteNum == 1){
            switch (lastState) {
                case "right":
                    image = rigth1;
                    break;
                case "left":
                    image = left1;
                    break;
            }
        }else if(spriteNum == 2){
            switch (lastState) {
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

    void somethingIsPressed() {

        if (keyH.upPressed) {
            if(gamePanel.cCheker.checkJumpX(this)){
                jump();
            }
        }
        if (keyH.downPressed) {
        }
        if (keyH.leftPressed) {
            state = "left";
            lastState = "left";
            if(speedX > maxSpeed * -1){
                speedX -= acceleration*2;
            }
        }
        if (keyH.rightPressed) {
            state = "right";
            lastState = "right";
            if (speedX < maxSpeed) {
                speedX += acceleration*2;
                
            }
        }        

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

    void gravity() {
        if(speedY < 10){
            speedY += 1;
        }
    }

    void jump() {
        speedY = -15;
    }
}
