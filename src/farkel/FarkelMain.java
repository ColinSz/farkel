
package farkel;

import java.util.ArrayList;

public class FarkelMain {

    public static void main(String[] args) {
        FarkelInteractions messages = new FarkelInteractions();
        if(messages.introduction())
            messages.showRules();
        
        ArrayList players = messages.howManyPlayers();
        
        
    }
    
}
