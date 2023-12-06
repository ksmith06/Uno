
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
        
        
        System.out.println("Welcome to UNO!");
        
        bytPlayerCount = Input.getInput("How many players are playing?", MAX_PLAYERS, MIN_PLAYERS);
        
        arrPlayers = new Player[bytPlayerCount];
        
        for (int i = 0; i < arrPlayers.length; i++)
        {
            arrPlayers[i] = new Player();
        }
        
        incrementTurn();
        
        do
        {
            byte bytInput;
            
            System.out.println("Pass the computer to " + currentPlayer.getName() + "! Hit enter when only they can see the screen.");
            
            Input.awaitInput();
            
            boolean bolHasPlayedCard = false;
            do
            {
                bytInput = Input.getInput(currentPlayer.getHand());
                
                if (bytInput == currentPlayer.getHand().size())
                {
                    currentPlayer.drawCard();
                }
                else
                {   
                    if (currentPlayer.getHand().get(bytInput).isCompatible(Deck.getCurrentCard()))
                    {
                        currentPlayer.playCard(bytInput);
                        bolHasPlayedCard = true;
                    }
                    else
                    {
                        System.out.println("You can't play this card! Pick another.");
                    }
                }
            }
            while (bolHasPlayedCard);
            
            incrementTurn();
        }
        while (!currentPlayer.isHandEmpty());
        
        System.out.println("Congrats " + currentPlayer.getName() + "! You've won!");
    }
    
    public static void reverse()
    {
        bolIsReversed = !bolIsReversed;
    }
    
    public static void incrementTurn()
    {
        if (!bolIsReversed)
        {
            if (bytTurn == arrPlayers.length)
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
