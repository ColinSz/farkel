
package farkel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;

public class myFrame extends javax.swing.JFrame{

    private static String playerNames[] = {"1", "2", "3", "4"};
    private static Object[][] playerID = new String[4][2];
    static ArrayList <FarkelPlayer> players = new ArrayList<FarkelPlayer>();
    static FarkelPlayer playerCurrent;
    private static int playerNumberCurrent = 0;
    //private static int[] diceActive = {0,0,0,0,0,0};
    private static int playerCurrentNumber = 0;
    private static int playerScoreThisRound = 0;
    private static int playerScore = 0;
    private static int playerScoreRollPrevious = 0;
    private static boolean endgame = false;
    
    public myFrame(){
       boolean result = (JOptionPane.showConfirmDialog(null,
               "Welcome to Farkel! In this game, you race\n"
             + "to 10,000 points by rolling dice and\n"
             + "adding values together! Would you like to read the rules?",
             "Welcome!", JOptionPane.YES_NO_OPTION)) == 0;
       
       if(result)
            showRules();
       
       retrievePlayers();
       //initalizeDice();
       initComponents();
       playerCurrent = players.get(0);
    }
    
    private static void retrievePlayers(){
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
            else {
                players.add(new FarkelPlayer((String)playerID[playerNumber][0]));
                playerNames[playerNumber] = (String)playerID[playerNumber][0];
            }
        }
        
        System.out.println(playerNumber);
        if(playerNumber == 1){
            playerNames[0] = "No Players Entered!";
            players.add(new FarkelPlayer("No Players Entered!"));
        }
    }

    private static void showRules(){
        JOptionPane.showMessageDialog(null, "yep these are the rules");
    }
    
    public static void RemoveDiceButtonStatus(boolean status){
        jButton2.setEnabled(status);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        
        
        // Get the currently installed look and feel
        LookAndFeel lf = UIManager.getLookAndFeel();
    
        // Install a different look and feel; specifically, the Windows look and feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (InstantiationException e) {
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        }


        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jPanel1 = new DicePanel(myDice);
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new ScorePanel();
        jLabel5 = new JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jComboBox1 = new javax.swing.JComboBox();
        
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setText(playerNames[0]);
        jFormattedTextField1.setBackground(new java.awt.Color(255, 0, 51));
        
        jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setMaximum(10000);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("0");
        
        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setText(playerNames[1]);
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("0");
        
        jProgressBar2.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar2.setMaximum(10000);
        
        if(players.size() < 2){
            jFormattedTextField2.setVisible(false);
            jProgressBar2.setVisible(false);
            jLabel2.setVisible(false);
        }        
        
        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField3.setText(playerNames[2]);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("0");
        
        jProgressBar3.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar3.setMaximum(10000);
        
        if(players.size() < 3){
            jFormattedTextField3.setVisible(false);
            jProgressBar3.setVisible(false);
            jLabel3.setVisible(false);
        }        
        
        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField4.setText(playerNames[3]);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("0");
        
        jProgressBar4.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar4.setMaximum(10000);
        
        if(players.size() < 4){
            jFormattedTextField4.setVisible(false);
            jProgressBar4.setVisible(false);
            jLabel4.setVisible(false);
        }
        
        jButton2 = new javax.swing.JButton();
                
        jButton2.setText("Add/Remove Dice");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButton2ActionPerformed(ae);
        }});
        
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 130));
        
        jButton1.setText("Bank");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Roll");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("!!!FARKEL!!!");
        jLabel5.setVisible(false);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(70, 70, 70))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jProgressBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jButton2))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new myFrame().setVisible(true);
            }
        });
    }
    
    private void updateRemovableDice(boolean[] die){
        jComboBox1.removeAllItems();
        int spot = 0;
        for(boolean dice: die){
            spot++;
            if(dice && !myDice[spot-1].isBanked())
                jComboBox1.addItem(spot);
        }
    }
    
    //Bank button pressed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
        System.out.println("bank pressed");
        if(myDice[0].isBanked() && myDice[1].isBanked() && myDice[2].isBanked() &&
            myDice[3].isBanked() && myDice[4].isBanked() && myDice[5].isBanked()) {
            playerScoreRollPrevious += playerScoreThisRound;
            playerScoreThisRound = 0;
            for(int i = 0; i <= 5; i++)     //reset all dice
                myDice[i].setBanked(false);
        }
        else
            turnEnd(false);
    }
    
    //Remove-dice button pressed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        System.out.println("remove-dice pressed");
        
        int[] diceToScore = {0,0,0,0,0,0};
        
        int i = (Integer)jComboBox1.getSelectedItem();
        System.out.println(i);
        myDice[i-1].setBanked(!myDice[i-1].isBanked());
        jPanel1.reDraw();
        
        for(int j = 0; j <= 5; j++){
            if(myDice[j].isBanked())
                diceToScore[j] = myDice[j].getValue();
        }
        
        boolean diceSelected = false;
        for(int j = 0; j <=5; j++){
            diceSelected = diceSelected || myDice[j].isBanked();
        }
        
        jButton3.setEnabled(diceSelected);
            
        playerScoreThisRound = CalculateScore.calculateScore(diceToScore)[0] + playerScoreRollPrevious;
        jPanel2.updateScoreThisRound(playerScoreThisRound);
    } 

    //Roll button pressed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println("roll pressed");
        
        //if all die are banked
        if(myDice[0].isBanked() && myDice[1].isBanked() && myDice[2].isBanked() &&
            myDice[3].isBanked() && myDice[4].isBanked() && myDice[5].isBanked()) {
            myDice[0].setBanked(false);
            myDice[1].setBanked(false);
            myDice[2].setBanked(false);
            myDice[3].setBanked(false);
            myDice[4].setBanked(false);
            myDice[5].setBanked(false);
        }
                
        int numberOfDiceRolled = 6;
        
        int[] tempArray = playerCurrent.rollDie(numberOfDiceRolled);
        for(int i = 0; i <= 5; i++){
            if(!myDice[i].isBanked) 
                myDice[i].setValue(tempArray[i]);
            else
                tempArray[i] = myDice[i].getValue();
        }

        jPanel1.updateDiceValues(tempArray);
        
        int[] score = CalculateScore.calculateScore(tempArray);
        boolean[] diceCanBeRemoved = {(score[1] == 0), (score[2] == 0), (score[3] == 0),
                                        (score[4] == 0), (score[5] == 0), (score[6] == 0)};
        for(int i = 0; i <= 5; i++){
            diceCanBeRemoved[i] = (diceCanBeRemoved[i] && !myDice[i].isBanked());
        }
        
        if(diceCanBeRemoved[0] || diceCanBeRemoved[1] || diceCanBeRemoved[2] 
                || diceCanBeRemoved[3] || diceCanBeRemoved[4] || diceCanBeRemoved[5]) {
            updateRemovableDice(diceCanBeRemoved);
            //jPanel2.updateScoreThisRound(score[0]);
            jLabel5.setVisible(false);
        }
        else {      //you farkeled!
            playerScoreThisRound = 0;
            playerScoreRollPrevious = 0;
            turnEnd(true);
            jLabel5.setVisible(true);
        }
    }        
        
    private void diceResetNotBanked(){
        for(int i = 0; i < myDice.length; i++)
            myDice[i].setBanked(false);
    }
    
    private void turnEnd(boolean farkle){
        diceResetNotBanked();

        System.out.println("turnEnd " + playerScore + " " + playerScoreThisRound);
        playerCurrent.setScoreTotal(playerScore + playerScoreThisRound);
        if(playerCurrent.getScoreTotal() > 10000){
            endgame = true;
            System.out.println("why are we here?");
        }
        updateProgress(playerCurrentNumber, playerCurrent.getScoreTotal());
        
        boolean gameOver = false;
        
        //endgame setting
        if(endgame) {
            gameOver = true;
            playerCurrent.setEndgameDone(true);
            for(FarkelPlayer playerFocus: players){
                gameOver = gameOver && playerFocus.getEndgameDone();
            }
        }
        
        if(gameOver) {
            String winner = "";
            int highScore = 0;
            int previousHighScore = 0;
            for(FarkelPlayer playerFocus: players){
                if(previousHighScore < playerFocus.getScoreTotal()){
                    winner = playerFocus.getName();
                    previousHighScore = playerFocus.getScoreTotal();
                }
            }
            
            JOptionPane.showMessageDialog(this, "Game over!\n\n" + winner + " won!"
                    + " Congradulations! You sucesssfully got " + previousHighScore + 
                    " points!" + "\n Swag, my friend. Swag.");
        }
        //game is over, show message
        else {
            //change currentPlayer
            if(playerCurrentNumber == (players.size() - 1))
                playerCurrentNumber = 0;
            else
                playerCurrentNumber++;
        
            playerCurrent = players.get(playerCurrentNumber);
            playerScore = playerCurrent.getScoreTotal();
            playerScoreThisRound = 0;
            playerScoreRollPrevious = 0;
        
            jPanel2.updateScoreThisRound(0);
            jPanel2.updateScoreBeforeRound(playerScore);
        
            if(!farkle)
                jButton3ActionPerformed(null);
        
            //switches which player is active
            if(playerCurrentNumber == 0){
                jFormattedTextField1.setBackground(new java.awt.Color(255, 0, 51));
                jFormattedTextField2.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField3.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField4.setBackground(new java.awt.Color(240, 240, 240));
            }
            else if (playerCurrentNumber == 1){
                jFormattedTextField2.setBackground(new java.awt.Color(255, 0, 51));
                jFormattedTextField1.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField3.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField4.setBackground(new java.awt.Color(240, 240, 240));
            }
            else if (playerCurrentNumber == 2){
                jFormattedTextField3.setBackground(new java.awt.Color(255, 0, 51));
                jFormattedTextField2.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField1.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField4.setBackground(new java.awt.Color(240, 240, 240));
            }
            else if (playerCurrentNumber == 3){
                jFormattedTextField4.setBackground(new java.awt.Color(255, 0, 51));
                jFormattedTextField3.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField1.setBackground(new java.awt.Color(240, 240, 240));
                jFormattedTextField2.setBackground(new java.awt.Color(240, 240, 240));
            }
        }
        
    }
    
    private void updateProgress(int thisPlayer, int score){
        if(thisPlayer == 0) {
            jProgressBar1.setValue(score);
            jLabel1.setText(Integer.toString(score));
        }
        else if(thisPlayer == 1) {
            jProgressBar2.setValue(score);
            jLabel2.setText(Integer.toString(score));
        }
        else if(thisPlayer == 2) {
            jProgressBar3.setValue(score);
            jLabel3.setText(Integer.toString(score));
        }
        else if(thisPlayer == 3){
            jProgressBar4.setValue(score);
            jLabel4.setText(Integer.toString(score));
        }
    }
    
    // Variables declaration - do not modify
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private static JFormattedTextField jFormattedTextField1;
    private static JFormattedTextField jFormattedTextField2;
    private static JFormattedTextField jFormattedTextField3;
    private static JFormattedTextField jFormattedTextField4;
    private static JLabel jLabel1;
    private static JLabel jLabel2;
    private static JLabel jLabel3;
    private static JLabel jLabel4;
    private static JLabel jLabel5;
    private static DicePanel jPanel1;
    private ScorePanel jPanel2;
    private static JProgressBar jProgressBar1;
    private static JProgressBar jProgressBar2;
    private static JProgressBar jProgressBar3;
    private static JProgressBar jProgressBar4;
    private static JSeparator jSeparator1;
    private static javax.swing.JComboBox jComboBox1;
    static Dice[] myDice = {new Dice(1), new Dice(2), new Dice(3), new Dice(4),
                                new Dice(5), new Dice(6)};
}