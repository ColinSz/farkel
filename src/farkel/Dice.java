/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farkel;

/**
 *
 * @author 009224
 */
public class Dice {
    
    int value = 0;
    boolean isBanked = false;
    
    public Dice(int newValue){
        value = newValue;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int valueNew){
        value = valueNew;
    }
    
    public boolean isBanked(){
        return isBanked;
    }
    
    public void setBanked(boolean isStored){
        isBanked = isStored;
    }
    
    public void resetDice(){
        isBanked = false;
        value = 1;
    }
    
    
}
