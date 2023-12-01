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
    
    public Player()
    {
        arlHand = new ArrayList<Card>();
    }
    
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
    
    public void insertCard(Card x)
    {
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
}
