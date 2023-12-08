import java.util.ArrayList;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private ArrayList<Card> arlHand;
    private String strName;
    private static byte bytNumOfPlayers;
    private static final byte bytHandSize = 7;
    
    public Player()
    {
        arlHand = new ArrayList<Card>();
        
        fillHand();
        
        bytNumOfPlayers++;
        
        strName = Input.getStringInput("Hello player " + bytNumOfPlayers + "! Please enter your name:");
    }
    
    private void fillHand()
    {
        for (byte i = 0; i < bytHandSize; i++)
        {
            drawCard();
        }
    }
    
    public void playCard(byte bytIndex)
    {
        if (arlHand.get(bytIndex) instanceof SpecialCard)
        {
            ((SpecialCard) arlHand.get(bytIndex)).cardEffect();
        }
        
        Deck.addToDiscardPile(arlHand.remove(bytIndex));
    }
    
    public void drawCard()
    {
        insertCard(Deck.drawCard());
    }
    
    public String getName()
    {
        return strName;
    }
    
    public ArrayList<Card> getHand()
    {
        return arlHand;
    }
    
    public boolean isHandEmpty()
    {
        return arlHand.size() == 0;
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
                return;
            }
        }
        
        arlHand.add(x);
    }
}
