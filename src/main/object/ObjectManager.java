package main.object;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjectManager {
     GamePanel gamePanel;
    public Object[] objects;
    public int mapObjectNum[][];

    public ObjectManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        objects = new Object[10];
        mapObjectNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/mapO.txt");
    }

    public void getTileImage(){

        try{
            objects[0] = new Object();
            objects[0].image = ImageIO.read(getClass().getResourceAsStream("/Objects/Spike.png"));
            objects[0].isSolid = true;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

     public void loadMap(String path){

        try{
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
                String line = br.readLine();
                String numbers[] = line.split(" ");

                while (col < gamePanel.maxWorldCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapObjectNum[col][row] = num;
                    col++;
                }

                if(col == gamePanel.maxWorldCol){
                    col = 0;
                    row++;
                }
            }

            br.close();
            is.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
    
        while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){

            int tileNum = mapObjectNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


            if(screenX + gamePanel.tileSize > 0 && screenX < gamePanel.screenWidth && 
                    screenY + gamePanel.tileSize > 0 && screenY < gamePanel.screenHeight){
                if(tileNum != 0){
                    g2.drawImage(objects[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                }
            }
            worldCol++;
            if(worldCol == gamePanel.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
