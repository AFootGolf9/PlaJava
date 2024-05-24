package main.hud;

import java.awt.Graphics2D;

import main.GamePanel;

public class HudManager {
    private LivesHud lh;

    public HudManager(GamePanel gp){
        lh = new LivesHud(gp.player);
    }

    public void draw(Graphics2D g2){
        lh.draw(g2);
    }
}
