package farkel;

import java.util.Random;

public class FarkelRandom {
    //use default constructor
    
    Random generator = new Random();
    
    public int[] generateRoll(int numberOfDiceRolled){
        int[] result = new int[5];
        for(int i = 0; numberOfDiceRolled != 0; numberOfDiceRolled--)
        {
            result[i] = generator.nextInt(5);
            i++;
        }
        
        return result;
    }
}