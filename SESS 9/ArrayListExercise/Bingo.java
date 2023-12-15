
import java.util.*;

public class Bingo
{
    private ArrayList<Integer> numbers;
    
    public Bingo(){
        numbers = new ArrayList<Integer>();
    }
    
    public void bingoNumGen (){
        
        Random generator = new Random();
        
        int newNumber = generator.nextInt(75)+1;
        
        numbers.add(newNumber);
    }
}
