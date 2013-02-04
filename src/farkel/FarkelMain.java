
package farkel;

import java.util.ArrayList;

public class FarkelMain {

    
    public static void main(String[] args) {
        if(FarkelInteractions.introduction())
            FarkelInteractions.showRules();
        
        ArrayList<FarkelPlayer> players = FarkelInteractions.howManyPlayersAndSetup();
        boolean gameNotOver = false;
        
        while(gameNotOver){
            int score = 0;
            FarkelInteractions.reInitializePlayerTable(players.get(0), score);
        }
        
    }
    
}
