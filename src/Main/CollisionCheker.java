package Main;

import Main.entity.Entity;

public class CollisionCheker {
    
    GamePanel gamePanel;

    public CollisionCheker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public boolean checkTile(Entity entity){

        int entityLeftWordX = entity.worldX + entity.solidArea.x;
        int entityRightWordX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWordY = entity.worldY + entity.solidArea.y;
        int entityBottonWordY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = ((entityLeftWordX + gamePanel.player.speedX) / gamePanel.tileSize);
        int entityRightCol = ((entityRightWordX + gamePanel.player.speedX) / gamePanel.tileSize);
        int entityTopRow = ((entityTopWordY + gamePanel.player.speedY) / gamePanel.tileSize);
        int entityBottonRow = ((entityBottonWordY + gamePanel.player.speedY) / gamePanel.tileSize);

        int tileNum1, tileNum2, tileNum3, tileNum4;

        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
        tileNum3 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottonRow];
        tileNum4 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottonRow];

        if(gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid || 
                gamePanel.tileManager.tiles[tileNum3].isSolid || gamePanel.tileManager.tiles[tileNum4].isSolid){
            return true;
        }
        return false;
    }
}
