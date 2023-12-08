
/**
 * Write a description of class GameManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameManager
{
    private static Player[] arrPlayers;
    private static byte bytTurn = -1;
    private static Player currentPlayer;
    private static boolean bolIsReversed = false;
    
    private static final byte MAX_PLAYERS = 6;
    private static final byte MIN_PLAYERS = 2;
    
    public static void main(String[] args)
    {
        byte bytPlayerCount;
        
        Deck.populateDeck();
        
        System.out.println("Welcome to UNO!");
        
        bytPlayerCount = Input.getInput("How many players are playing?", MAX_PLAYERS, MIN_PLAYERS);
        
        arrPlayers = new Player[bytPlayerCount];
        
        for (int i = 0; i < arrPlayers.length; i++)
        {
            arrPlayers[i] = new Player();
        }
        
        do
        {
            byte bytInput;
            
            nextTurn();
            
            System.out.println("The last card played was " + Deck.getCurrentCard() + ".");
            System.out.println("Pass the computer to " + currentPlayer.getName() + "! Hit enter when only they can see the screen.");
            
            Input.awaitInput();
            
            boolean bolHasPlayedCard = false;
            do
            {   
                bytInput = Input.getInput(currentPlayer.getHand());
                
                if (bytInput - 1 == currentPlayer.getHand().size())
                {
                    currentPlayer.drawCard();
                }
                else
                {   
                    if (currentPlayer.getHand().get(bytInput - 1).isCompatible(Deck.getCurrentCard()))
                    {
                        currentPlayer.playCard((byte) (bytInput - 1));
                        bolHasPlayedCard = true;
                    }
                    else
                    {
                        System.out.println("You can't play this card! Pick another.");
                    }
                }
            }
            while (!bolHasPlayedCard);
            
            System.out.println("Hit enter to end your turn.");
            
            Input.awaitInput();
            
            for (int i = 0; i < 50; i++)
            {
                System.out.println();
            }
        }
        while (!currentPlayer.isHandEmpty());
        
        System.out.println("Congrats " + currentPlayer.getName() + "! You've won!");
    }
    
    public static void reverse()
    {
        bolIsReversed = !bolIsReversed;
    }
    
    public static Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public static void nextTurn()
    {
        if (!bolIsReversed)
        {
            if (bytTurn == arrPlayers.length - 1)
            {
                bytTurn = 0;
            }
            else
            {
                bytTurn++;
            }
        }
        else
        {
            if (bytTurn == 0)
            {
                bytTurn = (byte) (arrPlayers.length - 1);
            }
            else
            {
                bytTurn--;
            }
        }
        
        currentPlayer = arrPlayers[bytTurn];
    }
}
