
package farkel;

import java.util.ArrayList;

public class FarkelMain {

    public static void main(String[] args) {
        if(FarkelInteractions.introduction())
            FarkelInteractions.showRules();
        
        ArrayList players = FarkelInteractions.howManyPlayers();
        
        
    }
    
}
