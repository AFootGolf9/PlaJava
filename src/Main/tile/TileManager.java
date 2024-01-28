package Main.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {
    
    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap("/maps/map.txt");
    }

    public void getTileImage(){

        try{
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Blocks/Sky.png"));
            tiles[0].isSolid = false;

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Blocks/Grass.png"));
            tiles[1].isSolid = true;

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/Blocks/Dirt.png"));
            tiles[2].isSolid = true;

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

            while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
                String line = br.readLine();
                String numbers[] = line.split(" ");

                while (col < gamePanel.maxScreenCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gamePanel.maxScreenCol){
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

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tiles[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            col++;
            x += gamePanel.tileSize;
            if(col == gamePanel.maxScreenCol){
                col = 0;
                row++;
                x = 0;
                y += gamePanel.tileSize;
            }
        }
    }
}
