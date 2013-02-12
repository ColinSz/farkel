package farkel;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    
    public DicePanel(){
        setBounds(0, 0, 600, 600);
        setPreferredSize(new Dimension(600, 600));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.WHITE);
        
        g2d.fillRect(5, 5, 100, 100);           //first dice
        g2d.fillRect(125, 5, 100, 100);         //second dice
        g2d.fillRect(125, 125, 100, 100);       //third dice
        g2d.fillRect(5, 125, 100, 100);         //fourth dice
        g2d.fillRect(245, 5, 100, 100);         //fifth dice
        g2d.fillRect(245, 125, 100, 100);       //sixth dice
        
        g2d.setColor(Color.BLACK);
        
        g2d.drawRect(5, 5, 100, 100);           //first dice
        g2d.drawRect(125, 5, 100, 100);         //second dice
        g2d.drawRect(125, 125, 100, 100);       //third dice
        g2d.drawRect(5, 125, 100, 100);         //fourth dice
        g2d.drawRect(245, 5, 100, 100);         //fifth dice
        g2d.drawRect(245, 125, 100, 100);       //sixth dice
        
        
    }
}
