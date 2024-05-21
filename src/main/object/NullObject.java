package main.object;

import main.GamePanel;

public class NullObject extends Object{
        
    public NullObject(){
        super();
        isSolid = false;
    }
    
    @Override
    public void onColision(GamePanel gamePanel){
        // Do nothing
    }
    
}
