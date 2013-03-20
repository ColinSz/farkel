
package farkel;

public class FarkelPlayer {
    
    private String playerName;
    private int scoreTotal = 0;
    boolean endgameDone = false;
    
    public FarkelPlayer(String playerID){
        playerName = playerID;
    }
    
    public String getName(){
        return playerName;
    }
    
    public int[] rollDie(int numberToRoll){
        FarkelRandom.generateRoll(numberToRoll);
        return FarkelRandom.generateRoll(numberToRoll);
    }
    
    public int getScoreTotal(){
        return scoreTotal;
    }
    
    public void setScoreTotal(int newScoreTotal){
        scoreTotal = newScoreTotal;
    }
    
    public void setEndgameDone(boolean valueNew) {
        endgameDone = valueNew;
    }
    
    public boolean getEndgameDone(){
        return endgameDone;
    }
        
    
}
