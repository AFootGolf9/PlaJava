package Main.entity;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity{
    
    GamePanel gamePanel;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        setDefautValues();
    }

    public void setDefautValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyH.upPressed) {
            y -= speed;
        }
        if (keyH.downPressed) {
            y += speed;
        }
        if (keyH.leftPressed) {
            x -= speed;
        }
        if (keyH.rightPressed) {
            x += speed;
        }
    }

    public void draw(java.awt.Graphics2D g) {
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
