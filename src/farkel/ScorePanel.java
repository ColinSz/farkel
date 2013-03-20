package farkel;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel{
    
    private int scorePrevious = 0;
    private JLabel scorePreviousLabel = new JLabel("String One");                       //Integer.toString(scorePrevious)
    private int scoreThisRound = 0;
    private JLabel scoreThisRoundLabel = new JLabel("String Two");  //Integer.toString(scoreThisRound)
    private int scoreIfBank = 0;
    private JLabel scoreIfBankLabel = new JLabel("String Three");        //Integer.toString(scoreIfBank)
    private GridBagConstraints scorePreviousC = new GridBagConstraints();
    private GridBagConstraints scoreThisRoundC = new GridBagConstraints();
    private GridBagConstraints scoreIfBankC = new GridBagConstraints();
    private GridBagLayout thisLayout = new GridBagLayout();
    private GridBagConstraints c = new GridBagConstraints();    
    
    public ScorePanel(){
        super();
        setLayout(thisLayout);
        setSize(200, 200);
        
        scorePreviousLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreThisRoundLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreIfBankLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.ipady = 5;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0,25,0,25);
        
        scorePreviousLabel.setText(Integer.toString(scorePrevious));
        thisLayout.setConstraints(scorePreviousLabel, c);
        this.add(scorePreviousLabel);

        scoreThisRoundLabel.setText(Integer.toString(scoreThisRound));
        thisLayout.setConstraints(scoreThisRoundLabel, c);
        this.add(scoreThisRoundLabel);
        
        scoreIfBankLabel.setText(Integer.toString(scoreIfBank));
        thisLayout.setConstraints(scoreIfBankLabel, c);
        this.add(scoreIfBankLabel);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        removeAll();
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        
        g2d.drawLine(10, 42, 60, 42);
        g2d.drawLine(10, 43, 61, 43);
        
        g2d.drawLine(16, 27, 16, 37);
        g2d.drawLine(15, 28, 15, 38);
        g2d.drawLine(10, 33, 20, 33);
        g2d.drawLine(11, 34, 21, 34);
        
        scoreIfBank = scorePrevious + scoreThisRound;
        
        scorePreviousLabel.setText(Integer.toString(scorePrevious));
        scoreThisRoundLabel.setText(Integer.toString(scoreThisRound));
        scoreIfBankLabel.setText(Integer.toString(scoreIfBank));
                
        thisLayout.removeLayoutComponent(scorePreviousLabel);
        thisLayout.removeLayoutComponent(scoreThisRoundLabel);
        thisLayout.removeLayoutComponent(scoreIfBankLabel);
        
        thisLayout.setConstraints(scorePreviousLabel, c);
        this.add(scorePreviousLabel);
        
        thisLayout.setConstraints(scoreThisRoundLabel, c);
        this.add(scoreThisRoundLabel);
        
        thisLayout.setConstraints(scoreIfBankLabel, c);
        this.add(scoreIfBankLabel);
        
        setVisible(true);
        
        validate();
    }
    
    public void updateScoreBeforeRound(int scoreOld){
        scorePrevious = scoreOld;
        reDraw();
    }
    
    public void updateScoreThisRound(int scoreCurrent){
        scoreThisRound = scoreCurrent;
        scoreIfBank = scorePrevious+scoreCurrent;
        reDraw();
    }
    
    public int returnScoreIfBanked(){
        return scoreIfBank;
    }
    
    private void reDraw(){
        invalidate();
        revalidate();
        repaint();
    }
    
    public void update(Graphics g){
        System.out.println("in update method woo!");
    }
}
