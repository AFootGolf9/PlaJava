package main.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Spike extends Object{
        
    public Spike(){
        super();
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Spike.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        isSolid = false;
    }

    @Override
    public void onColision(GamePanel gamePanel){
        gamePanel.player.damageTaken(1);
    }
    
}
