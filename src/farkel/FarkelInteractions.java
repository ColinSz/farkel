package farkel;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class FarkelInteractions {
    //use default constructor

    private static JFrame frame = new JFrame("Farkel");
    
    public FarkelInteractions()
    {

    }

    public static boolean introduction(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocation(200,200);
        frame.setSize(800,600);
        frame.setVisible(true);
        
    boolean result = (JOptionPane.showConfirmDialog(null,
             "Welcome to Farkel! In this game, you race\n"
            + "to 10,000 points by rolling dice and\n"
            + "adding values together! Would you like to read the rules?",
            "Welcome!", JOptionPane.YES_NO_OPTION)) == 0;

    return result;
}

    public static void showRules(){
        JOptionPane.showMessageDialog(null, "yep these are the rules");
    }

    public static ArrayList howManyPlayers(){

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
        JPanel listOfPlayers = new JPanel();
        listOfPlayers.setLayout(new FlowLayout());
        JLabel labelPlayerList = new JLabel(playerList);
        listOfPlayers.add(labelPlayerList);
        
        frame.add(listOfPlayers);
        frame.repaint();
        return players;

    }



}
