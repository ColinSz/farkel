package farkel;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    
    private int numberDiceDisplayed = 6;
    
    public DicePanel(){
        setBounds(0, 0, 600, 600);
        setPreferredSize(new Dimension(600, 600));
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        System.out.println("paintComponent Dice Panel");
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        if(numberDiceDisplayed == 6)
            myFrame.AddDiceButtonStatus(false);
        else if(numberDiceDisplayed == 5)
            myFrame.AddDiceButtonStatus(true);
        else if(numberDiceDisplayed == 1)
            myFrame.RemoveDiceButtonStatus(false);
        else if (numberDiceDisplayed == 2)
            myFrame.RemoveDiceButtonStatus(true);
        g2d.setColor(Color.WHITE);
        for(int i = numberDiceDisplayed - 1; i >= 0; i--) {
            if(i<3)
                g2d.fillRect(25+75*i, 5, 50, 50);
            else
                g2d.fillRect(25+75*(i-3), 75, 50, 50);
        }
        
        g2d.setColor(Color.BLACK);
        for(int i = numberDiceDisplayed - 1; i >=0; i--) {
            if(i<3)
                g2d.drawRect(25+75*i, 5, 50, 50);
            else
                g2d.drawRect(25+75*(i-3), 75, 50, 50);
        }
        
    }
    
    public void addDice(){
        numberDiceDisplayed += 1;
        removeAll();
        revalidate();
        repaint();
        
    }
    
    public void removeDice(){
        numberDiceDisplayed -= 1;
        removeAll();
        revalidate();
        repaint();
    }
    
}
