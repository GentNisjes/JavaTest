
/**
 * Write a description of class Racket here.
 *
 * @author KP
 * @version October 2021
 */
public class Racket
{
    private String type;
    private int weight;
    private char sport;

    /**
     * Constructor for objects of class Racket
     */
    public Racket(String type, int weight, char sport)
    {
        this.type = type;
        this.weight = weight;
        this.sport = sport;
    }

    public String getType()
    {
        return type;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public char getSport()
    {
        return sport;
    }
}
