package farkel;

/*import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;*/
import java.util.ArrayList;
//import java.awt.FlowLayout;
//import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FarkelInteractions {
    //use default constructor

    private static JFrame frame = new JFrame("Farkel");
    private static JPanel listOfPlayers = new JPanel();
    private static JPanel controls = new JPanel();
    private static JTable playerTable;
    private static JScrollPane playerTableScroll;
    private static Object[][] playerID = new String[4][2];
    private static String columnTitles[] = {"Player Name", "Score"};
    private static DicePanel myDice = new DicePanel();
    
    public FarkelInteractions()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));
        frame.setLocation(200,200);
        frame.setSize(1000,400);
        listOfPlayers.setLayout(new BoxLayout(listOfPlayers,BoxLayout.Y_AXIS));
        controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
        
        for(int i = 0; i <= 3; i++)
        {
            playerID[i][1] = "0";
            System.out.println(playerID[i][1]);
        }
    }

    public static runFrame(){
        Frame party = new Frame();
        party
    }
    
    public static boolean introduction(){
        
        boolean result = (JOptionPane.showConfirmDialog(null,
               "Welcome to Farkel! In this game, you race\n"
             + "to 10,000 points by rolling dice and\n"
             + "adding values together! Would you like to read the rules?",
             "Welcome!", JOptionPane.YES_NO_OPTION)) == 0;
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocation(200,200);
        frame.setSize(800,600);
        
        for(int i = 0; i <= 3; i++)
        {
            playerID[i][1] = "0";
            System.out.println(playerID[i][1]);
        }

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
        
        initalizePlayerTable();
        initalizeControls();
        frame.add(myDice);
        reinitializeGUI();

        return players;

    }
    
    public static void initalizePlayerTable(){
        playerTable = new JTable(playerID, columnTitles);
        displayPlayerTable();
    }
    
    public static void reInitializePlayerTable(FarkelPlayer player, int score){
        
        //Find whichever score to change
        int playerIDNumber = 0;
        if(player != null){
            while(!playerID[playerIDNumber][0].equals(player.getName()))
                playerIDNumber++;
        }
        
        playerID[playerIDNumber][1] = Integer.toString(score);
        
        playerTable = new JTable(playerID, columnTitles);
        
        displayPlayerTable();
    }

    private static void displayPlayerTable(){
        playerTable.setEnabled(false);
        playerTableScroll = new JScrollPane(playerTable);
        Dimension d = playerTable.getPreferredSize();
        playerTableScroll.setPreferredSize(new Dimension(d.width, playerTable.getRowHeight()*5 + 5));
        
        listOfPlayers.add(playerTableScroll);
        
        frame.add(playerTableScroll);
        reinitializeGUI();
    }

    private static void initalizeControls(){
        JButton roll = new JButton("roll!");
        controls.add(roll);
        frame.add(controls);
        reinitializeGUI();
        roll.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        //maybe trip a flag?
                        System.out.println("Button pressed!");
                    }
                });
    }
    
    /*private static void reinitializeDice(){
        frame.add(myDice);
        reinitializeGUI();
    }*/
    
    private static void reinitializeGUI(){
        //frame.pack();
        //paintComponent(myGraphics);
        frame.repaint();
        if(!frame.isShowing())
            frame.setVisible(true);
    }
}

