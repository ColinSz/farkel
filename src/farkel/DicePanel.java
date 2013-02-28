package farkel;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    
    private int numberDiceDisplayed = 6;
    
    public DicePanel(){
        //setBounds(0, 0, 250, 130);
        setPreferredSize(new Dimension(240, 130));
        //revalidate();
        //repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        removeAll();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.WHITE);
        
        for(int i = 2; i >= 0; i--){
            g2d.fillRect(25+75*i, 5, 50, 50);
            g2d.fillRect(25+75*i, 75, 50, 50);
        }
 

        g2d.setColor(Color.BLACK);
        for(int i = 2; i >= 0; i--){
            g2d.drawRect(25+75*i, 5, 50, 50);
            g2d.drawRect(25+75*i, 75, 50, 50);     
        }
    }
    
    /*public void addDice(){
        numberDiceDisplayed += 1;
        removeAll();
        revalidate();
        repaint();
        
    }*/
    
    public void removeDice(){
        numberDiceDisplayed -= 1;
        removeAll();
        revalidate();
        repaint();
    }
    
    public void resetDice(){
        numberDiceDisplayed = 6;
        removeAll();
        revalidate();
        repaint();
    }
    
    public void diceValue(int[] diceNumber, int[] value){
        
    }
    
    private void reDraw(){
        removeAll();
        revalidate();
        repaint();
    }
    
}
