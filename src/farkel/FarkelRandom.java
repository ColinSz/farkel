package farkel;

import java.util.Random;

public class FarkelRandom {
    //use default constructor
    
    static Random generator = new Random();
    
    public static int[] generateRoll(int numberOfDiceToRoll){
        int[] result = new int[numberOfDiceToRoll];
        for(int i = 0; numberOfDiceToRoll != 0; numberOfDiceToRoll--)
        {
            result[i] = 1+generator.nextInt(5);
            i++;
        }
        
        return result;
    }
}