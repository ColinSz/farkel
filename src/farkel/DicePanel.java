package farkel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DicePanel extends JPanel implements MouseListener {
    
    int diceValues[];
    Dice[] die;
    myFrame thisFrame;
    
    Graphics2D g2d;
    
    public DicePanel(Dice[] diceImport, myFrame thisIsMyFrame){
        //setBounds(0, 0, 250, 130);
        setPreferredSize(new Dimension(240, 130));
        //revalidate();
        //repaint();

        die = diceImport;
        
        addMouseListener(this);
        
        thisFrame = thisIsMyFrame;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        removeAll();
        super.paintComponent(g);
        ///Graphics2D g2d = (Graphics2D)g;
        g2d = (Graphics2D)g;
        
        //g2d.setColor(Color.WHITE);
        
        //draw all of the rectangles inside
        for(int i = 0; i <= 5; i++){
            drawDice(g2d, die[i], i);
            /*g2d.fillRect(25+75*i, 5, 50, 50);
            g2d.fillRect(25+75*i, 75, 50, 50);
            drawDice(g2d, 25+75*i, 5, die[i].getValue());
            drawDice(g2d, 25+75*i, 75, die[i+3].getValue());*/
        }
        //draw the rectangle borders
        /*g2d.setColor(Color.BLACK);
        for(int i = 0; i <= 2; i++){
            g2d.drawRect(25+75*i, 5, 50, 50);
            g2d.drawRect(25+75*i, 75, 50, 50);     
        }*/
         
    }
    
    public void drawDice(Graphics2D g2d, Dice dice, int spot){
        
        int diceValue = dice.getValue();
        int xStart = 25+75*spot;
        int yStart = 5;
        Color background = Color.WHITE;
        Color foreground = Color.BLACK;
        
        if(dice.isBanked()) {
            background = Color.BLACK;
            foreground = Color.WHITE;
        }
        
        g2d.setColor(background);
        
        if(spot<=2){
            g2d.fillRect(xStart, yStart, 50, 50);
        }
        else{
            yStart = 75;
            xStart = 25+75*(spot-3);
            g2d.fillRect(xStart, yStart, 50, 50);
        }

        g2d.setColor(foreground);
        
        g2d.drawRect(xStart, yStart, 50, 50);
        
        if(diceValue == 1)
            g2d.fillOval(xStart+20, yStart+20, 10, 10);
        else if(diceValue == 2){
            g2d.fillOval(xStart+5, yStart+5, 10, 10);
            g2d.fillOval(xStart+35, yStart+35, 10, 10);
        }
        else if(diceValue == 3){
            g2d.fillOval(xStart+5, yStart+5, 10, 10);
            g2d.fillOval(xStart+20, yStart+20, 10, 10);
            g2d.fillOval(xStart+35, yStart+35, 10, 10);
        }
        else if(diceValue == 4){
            g2d.fillOval(xStart+5, yStart+5, 10, 10);
            g2d.fillOval(xStart+5, yStart+35, 10, 10);
            g2d.fillOval(xStart+35, yStart+5, 10, 10);
            g2d.fillOval(xStart+35, yStart+35, 10, 10);
        }
        else if(diceValue == 5){
            g2d.fillOval(xStart+5, yStart+5, 10, 10);
            g2d.fillOval(xStart+5, yStart+35, 10, 10);
            g2d.fillOval(xStart+20, yStart+20, 10, 10);
            g2d.fillOval(xStart+35, yStart+5, 10, 10);
            g2d.fillOval(xStart+35, yStart+35, 10, 10);
        }
        else if(diceValue == 6){
            g2d.fillOval(xStart+5, yStart+5, 10, 10);
            g2d.fillOval(xStart+5, yStart+20, 10, 10);
            g2d.fillOval(xStart+5, yStart+35, 10, 10);
            g2d.fillOval(xStart+35, yStart+5, 10, 10);
            g2d.fillOval(xStart+35, yStart+20, 10, 10);
            g2d.fillOval(xStart+35, yStart+35, 10, 10);
        }

    }
    
    public void reDraw(){
        removeAll();
        revalidate();
        repaint();
    }
    
    public void updateDiceValues(int newValues[]){
        diceValues = newValues;
        reDraw();
    }
    
    public void mousePressed(MouseEvent e){
         System.out.println(Integer.toString(e.getX()) + " " + Integer.toString(e.getY()));
         int i = 0;
         boolean found = false;
         int xStart = 0;
         int yStart = 0;
         while(!found && i <= 5) {
             if(i<=2){        
                 xStart = 25+75*i;
                 yStart = 5;
             }
             else{
                 yStart = 75;
                 xStart = 25+75*(i-3);
             }
             
             if((e.getX() < (xStart+50)) && (e.getX() > xStart) && 
                     (e.getY() < (yStart + 50)) && (e.getY() > yStart)){
                 System.out.println("Success! " + (i+1));
                 found = true;
             }
             i++;
         }
         i--;
         thisFrame.setDiceBankedFlip(i);
         
         
    }
    
    public void mouseExited(MouseEvent e){
        //I think I just have to instantiate this method but I don't want to do anything so...
    }
    
    public void mouseEntered(MouseEvent e){
        //I think I just have to instantiate this method but I don't want to do anything so...
    }
    
    public void mouseClicked(MouseEvent e){
        //I think I just have to instantiate this method but I don't want to do anything so...
    }
    
    public void mouseReleased(MouseEvent e){
        //I think I just have to instantiate this method but I don't want to do anything so...
    }
    
    
}
