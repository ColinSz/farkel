
package farkel;

public class FarkelPlayer {
    
    private String playerName;
    private int scoreTotal = 0;
    private int scoreThisRound = 0;
    
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
}
