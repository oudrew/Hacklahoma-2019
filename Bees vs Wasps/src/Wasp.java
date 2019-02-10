import java.util.HashMap;

public class Wasp 
{
    private HashMap<Integer, Card> deck;
    private int hive;
    private int modifier;
    
    public Wasp()
    {
        deck = new HashMap<Integer, Card>();
        hive = 20;
        modifier = 0;
    }
    
    public void addCard(Card c)
    {
        deck.put(c.getID(), c);
    }
    
    public void incMod()
    {
        modifier++;
    }
    
}
