
package farkel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;

public class myFrame extends javax.swing.JFrame{

    private static String playerNames[] = {"1", "2", "3", "4"};
    private static Object[][] playerID = new String[4][2];
    static ArrayList players = new ArrayList();
    
    public myFrame(){
       boolean result = (JOptionPane.showConfirmDialog(null,
               "Welcome to Farkel! In this game, you race\n"
             + "to 10,000 points by rolling dice and\n"
             + "adding values together! Would you like to read the rules?",
             "Welcome!", JOptionPane.YES_NO_OPTION)) == 0;
       
       if(result)
            showRules();
       
       retrievePlayers();
       
       initComponents();
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
            else
            {
                players.add(new FarkelPlayer((String)playerID[playerNumber][0]));
                playerNames[playerNumber] = (String)playerID[playerNumber][0];
            }
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
        jPanel1 = new DicePanel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jComboBox1 = new javax.swing.JComboBox();
        
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setText(playerNames[0]);

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField2.setText(playerNames[1]);

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField3.setText(playerNames[2]);

        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField4.setText(playerNames[3]);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setMaximum(10000);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("0");
        
        jProgressBar2.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar2.setMaximum(10000);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("0");
        
        jProgressBar3.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar3.setMaximum(10000);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("0");
        
        jProgressBar4.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar4.setMaximum(10000);
        
        jButton2 = new javax.swing.JButton();
                
        jButton2.setText("Remove Dice");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jPanel1.removeDice();
                System.out.println("Dice removed!");
        }});
        
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 130));
        
        /*javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );*/

        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(8, 8, 8))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(55, 55, 55))
        );

        pack();

    }
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
    
    private void updateRemovableDice(int... die){
         jComboBox1.removeAllItems();
         for(int dice:die){
             jComboBox1.addItem(dice);
         }  
   }
    
    // Variables declaration - do not modify
    private static javax.swing.JButton jButton2;
    private static JFormattedTextField jFormattedTextField1;
    private static JFormattedTextField jFormattedTextField2;
    private static JFormattedTextField jFormattedTextField3;
    private static JFormattedTextField jFormattedTextField4;
    private static JLabel jLabel1;
    private static JLabel jLabel2;
    private static JLabel jLabel3;
    private static JLabel jLabel4;
    private static DicePanel jPanel1;
    private static JProgressBar jProgressBar1;
    private static JProgressBar jProgressBar2;
    private static JProgressBar jProgressBar3;
    private static JProgressBar jProgressBar4;
    private static JSeparator jSeparator1;
    private static javax.swing.JComboBox jComboBox1;
    // End of variables declaration
}
