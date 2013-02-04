package farkel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class FarkelInteractions {
    //use default constructor

    private static JFrame frame = new JFrame("Farkel");
    private static JPanel listOfPlayers = new JPanel();
    private static JTable playerTable;
    private static JScrollPane playerTableScroll;
    private static Object[][] playerID = new String[4][2];
    private static String columnTitles[] = {"Player Name", "Score"};
    
    public FarkelInteractions()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocation(200,200);
        frame.setSize(800,600);
    }

    public static boolean introduction(){
        
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

    public static ArrayList howManyPlayersAndSetup(){

        ArrayList players = new ArrayList();
        boolean continueMakingPlayers = true;
        
        for(int ctr = 0; ctr != 3; ctr++)
            playerID[ctr][0] = "0";
            
        int playerNumber = 0;
        
        for(playerNumber = 0; continueMakingPlayers && playerNumber < 4; playerNumber++)
        {
            playerID[playerNumber][0] = JOptionPane.showInputDialog(null, "What is the next player name?"
                    + " Hit cancel when you are done making players!"
                    + " You only have " + (4-playerNumber) + " slots left!");
            if((playerID[playerNumber][0] == (null))|| (playerID[playerNumber][0].equals("")))
                continueMakingPlayers = false;
            else
            {
                players.add(new FarkelPlayer((String)playerID[playerNumber][0]));
            }
        }
        
        playerTable = new JTable(playerID, columnTitles);
        //playerTable.setModel(playerTableModel);
        playerTable.setEnabled(false);
        playerTableScroll = new JScrollPane(playerTable);
        listOfPlayers.add(playerTableScroll);
        
        frame.add(playerTableScroll);
        frame.pack();
        frame.repaint();
        frame.setVisible(true);

        return players;

    }
    
    public static void initalizePlayerTable(){
        playerTable = new JTable(playerID, columnTitles);
        displayPlayerTable();
    }
    
    public static void reInitializePlayerTable(FarkelPlayer player, int score){
        
        //Find whichever score to change
        int playerIDNumber = 0;
        while(!playerID[playerIDNumber][0].equals(player.getName()))
            playerIDNumber++;
        
        playerID[playerIDNumber][1] = score;
        
        playerTable = new JTable(playerID, columnTitles);
        
        displayPlayerTable();
    }

    private static void displayPlayerTable(){
        playerTable.setEnabled(false);
        playerTableScroll = new JScrollPane(playerTable);
        listOfPlayers.add(playerTableScroll);
        
        frame.add(playerTableScroll);
        frame.pack();
        frame.repaint();
        frame.setVisible(true);
    }



}
