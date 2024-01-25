package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 pixels
    final int scale = 3; // 3x scale

    final int tileSize = originalTileSize * scale; // 48x48 pixels
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set player's initial position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    @Override
    public void run() {
        while(gameThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }
    public void  paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY , tileSize, tileSize);

        g2.dispose();
    }
}
