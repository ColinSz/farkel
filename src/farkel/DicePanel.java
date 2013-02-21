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
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.WHITE);
        for(int i = numberDiceDisplayed - 1; i >= 0; i--) {
            if(i<3)
                g2d.fillRect(5+75*i, 5, 50, 50);
            else
                g2d.fillRect(5+75*(i-3), 75, 50, 50);
        }
        
        g2d.setColor(Color.BLACK);
        for(int i = numberDiceDisplayed - 1; i >=0; i--) {
            if(i<3)
                g2d.drawRect(5+75*i, 5, 50, 50);
            else
                g2d.drawRect(5+75*(i-3), 75, 50, 50);
        }
        
    }
    
    public void setNumberOfDice(int newNumber){
        numberDiceDisplayed = newNumber;
    }
    
}
