import java.util.ArrayList;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    ArrayList<Card> arlHand;
    
    private final int HAND_SIZE = 7;
    
    public Player()
    {
        arlHand = new ArrayList<Card>();
    }
    
    // probably unnessesary, since we're just inserting on every draw
    public void sortHand()
    {
        ArrayList<Card> arlTemp = arlHand;
        arlHand = new ArrayList<Card>();
        
        arlHand.add(arlTemp.get(0));
        
        for (int i = 1; i < arlTemp.size(); i++)
        {
            insertCard(arlTemp.get(i));
        }
    }
    
    public void fillHand()
    {
        for (int i = 0; i < HAND_SIZE; i++)
        {
            drawCard();
        }
    }
    
    private void insertCard(Card x)
    {
        if (arlHand.size() == 0)
        {
            arlHand.add(x);
        }
        
        for (int i = 0; i < arlHand.size(); i++)
        {
            if (x.getColour() < arlHand.get(i).getColour() 
                || (x.getColour() == arlHand.get(i).getColour() && x.getType() < arlHand.get(i).getType()))
            {
                arlHand.add(i, x);
                break;
            }
        }
    }
    
    public Card drawCard()
    {
        Card cardDrawn = Deck.drawCard();
        
        insertCard(cardDrawn);
        
        return cardDrawn;
    }
    
    public void playCard(int intIndex)
    {
        Card cardPlayed = arlHand.remove(intIndex);
        
        Deck.addToDiscardPile(cardPlayed);
        
        if (cardPlayed instanceof SpecialCard)
        {
            ((SpecialCard) cardPlayed).cardEffect();
        }
    }
}
