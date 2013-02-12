package farkel;

import java.util.Random;

public class FarkelRandom {
    //use default constructor
    
    Random generator = new Random();
    
    public int[] generateRoll(int numberOfDiceToRoll){
        int[] result = new int[numberOfDiceToRoll];
        for(int i = 0; numberOfDiceToRoll != 0; numberOfDiceToRoll--)
        {
            result[i] = generator.nextInt(5);
            i++;
        }
        
        return result;
    }
}