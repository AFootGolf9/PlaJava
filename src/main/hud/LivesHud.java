package main.hud;

import java.awt.Graphics2D;
import main.entity.Entity;

public class LivesHud {
    Entity player;
    HudObject heart = new HudObject("/Icons/heart.png");

    LivesHud(Entity ent){
        player = ent;
    }


    public void draw(Graphics2D g2){

        for(int i = 0; i < player.lives; i++){
            g2.drawImage(heart.image, 10 + i * 30, 10, 30, 30, null);
        }
    }
}
