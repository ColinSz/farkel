package farkel;

import javax.swing.*;
import java.util.ArrayList;

public class FarkelInteractions {
    //use default constructor

    JFrame frame;

    public FarkelInteractions()
    {
        frame = new JFrame("Farkel v1.6 Cupcake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200,200);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public boolean introduction(){
    boolean result = (JOptionPane.showConfirmDialog(null,
             "Welcome to Farkel! In this game, you race\n"
            + "to 10,000 points by rolling dice and\n"
            + "adding values together! Would you like to read the rules?",
            "Welcome!", JOptionPane.YES_NO_OPTION)) == 0;

    return result;
}

    public void showRules(){
        JOptionPane.showMessageDialog(null, "yep these are the rules");
    }

    public ArrayList howManyPlayers(){

        ArrayList players = new ArrayList();
        boolean continueMakingPlayers = true;
        String playerList = "";

        for(int playerNumber = 0; continueMakingPlayers; playerNumber++)
        {
            String playerID = JOptionPane.showInputDialog("What is the next player name?"
                    + " Hit cancel when you are done making players!");
            if((playerID == null) || (playerID == ""))
                continueMakingPlayers = false;
            else
            {
                players.add(new FarkelPlayer(playerID));
                playerList += (playerID + " ");
            }
        }

        JLabel labelPlayerList = new JLabel(playerList);

        frame.getContentPane().add(labelPlayerList);

        return players;

    }



}
