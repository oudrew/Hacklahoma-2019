import java.util.ArrayList;
import java.util.HashMap;

public class Bees 
{
    private HashMap<Integer, Card> deck;
    private int hive;
    
    public Bees()
    {
        deck = new HashMap<Integer, Card>();
        hive = 20;
    }
    
    public void addCard(Card c)
    {
        deck.put(c.getID(), c);
    }
    
    public void removeCard(Card c)
    {
        deck.remove(c.getID());
    }
}
