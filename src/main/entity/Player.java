package main.entity;

import java.io.IOException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.utility.ImagesUtil;

public class Player extends Entity{
    
    GamePanel gamePanel;
    KeyHandler keyH;

    public int screenX;
    public int screenY;

    public int centerX;
    public int centerY;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        int pixelValue = gamePanel.tileSize / 16;
        solidArea = new Rectangle(pixelValue, pixelValue , gamePanel.tileSize - pixelValue*2, gamePanel.tileSize - pixelValue*4);

        setDefautValues();
        getPlayerImage();

        centerX = screenX;
        centerY = screenY;
    }

    public void setDefautValues() {
        worldX = gamePanel.tileSize * 9;
        worldY = gamePanel.tileSize * 7;
        speedX = 0; speedY = 0;
        maxSpeed = gamePanel.tileSize / 12;
        acceleration = 1;
        state = "right";
        lastState = "right";
        lives = 3;
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
            if(screenX + speedX < gamePanel.screenWidth - gamePanel.tileSize * 4 && screenX + speedX > gamePanel.tileSize * 4){
                screenX += speedX;
            }else{
                //centerX += speedX;
            }
        }else{
            speedX = 0;
        }

        if (!gamePanel.cCheker.checkTileY(this)) {
            worldY += speedY;
            if(screenY + speedY < gamePanel.screenHeight - gamePanel.tileSize * 3 && screenY + speedY > gamePanel.tileSize * 3){
                screenY += speedY;
            }else{
                if(true){

                }
                //centerY += speedY;
            }
        }else{
            speedY = 0;
        }

        gamePanel.cCheker.checkObject(this);
        
    }

    public void draw(java.awt.Graphics2D g2) {
        System.out.println(lives);
        
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
            if(speedX >= maxSpeed * -1){
                speedX -= acceleration*2;
            }
        }
        if (keyH.rightPressed) {
            state = "right";
            lastState = "right";
            if (speedX <= maxSpeed) {
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
        if(speedY < gamePanel.tileSize / 4){
            speedY += 1 * (gamePanel.scale / 2);
        }
    }

    void jump() {
        speedY = gamePanel.tileSize / -3;
    }
}
