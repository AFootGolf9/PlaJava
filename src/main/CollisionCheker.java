package main;

import main.entity.Entity;

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

    public boolean checkTileX(Entity entity) {
        int entityLeftWordX = entity.worldX + entity.solidArea.x;
        int entityRightWordX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWordY = entity.worldY + entity.solidArea.y;
        int entityBottonWordY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = ((entityLeftWordX + gamePanel.player.speedX) / gamePanel.tileSize);
        int entityRightCol = ((entityRightWordX + gamePanel.player.speedX) / gamePanel.tileSize);
        int entityTopRow = (entityTopWordY / gamePanel.tileSize);
        int entityBottonRow = (entityBottonWordY / gamePanel.tileSize);

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

    public boolean checkTileY(Entity entity){

        int entityLeftWordX = entity.worldX + entity.solidArea.x;
        int entityRightWordX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWordY = entity.worldY + entity.solidArea.y;
        int entityBottonWordY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = (entityLeftWordX / gamePanel.tileSize);
        int entityRightCol = (entityRightWordX / gamePanel.tileSize);
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

    public boolean checkJumpX(Entity entity){

        int entityLeftWordX = entity.worldX + entity.solidArea.x;
        int entityRightWordX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityBottonWordY = entity.worldY + entity.solidArea.y + entity.solidArea.height + 5;

        int entityLeftCol = (entityLeftWordX / gamePanel.tileSize);
        int entityRightCol = (entityRightWordX / gamePanel.tileSize);
        int entityBottonRow = (entityBottonWordY / gamePanel.tileSize);

        int tileNum1, tileNum2;

        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottonRow];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottonRow];

        if(gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid){
            return true;
        }
        return false;
    }

    public void checkObject(Entity entity){
        
        int entityLeftWordX = entity.worldX + entity.solidArea.x;
        int entityRightWordX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWordY = entity.worldY + entity.solidArea.y;
        int entityBottonWordY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = ((entityLeftWordX) / gamePanel.tileSize);
        int entityRightCol = ((entityRightWordX) / gamePanel.tileSize);
        int entityTopRow = ((entityTopWordY) / gamePanel.tileSize);
        int entityBottonRow = ((entityBottonWordY) / gamePanel.tileSize);

        int objectNum1, objectNum2, objectNum3, objectNum4;

        objectNum1 = gamePanel.objectManager.mapObjectNum[entityLeftCol][entityTopRow];
        objectNum2 = gamePanel.objectManager.mapObjectNum[entityRightCol][entityTopRow];
        objectNum3 = gamePanel.objectManager.mapObjectNum[entityLeftCol][entityBottonRow];
        objectNum4 = gamePanel.objectManager.mapObjectNum[entityRightCol][entityBottonRow];

        gamePanel.objectManager.objects[objectNum1].onColision(gamePanel);
        gamePanel.objectManager.objects[objectNum2].onColision(gamePanel);
        gamePanel.objectManager.objects[objectNum3].onColision(gamePanel);
        gamePanel.objectManager.objects[objectNum4].onColision(gamePanel);
    }

}
