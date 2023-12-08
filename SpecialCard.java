
/**
 * The SpecialCard class contains a constructor and a cardEffect method.
 * This method enacts a special ability on the deck/players depending on the type of card.
 * 
 * @author (Ibraheem Dawod)
 * @version (2023-12-05)
 */
public class SpecialCard extends Card
{   
    // Constructor for SpecialCard
    public SpecialCard(char chrColour, char chrType) {
        
        // Calls superclass constructor, taking in variables passed in
        super(chrColour, chrType);
    }
    
    // void method with no parameters to enact a certain special ability on the deck/players
    public void cardEffect() {
        
        // Switch case statement based on the type of the current card
        switch(getType()){
            case CHR_REVERSE:
                
                // Run the reverse method in GameManager
                GameManager.reverse();
                
                // Inform the players of the play switch
                System.out.println(GameManager.getCurrentPlayer().getName() + " has reversed the order of playing!");
                break;
            case CHR_SKIP:
                
                // Run the nextTurn method in GameManager
                GameManager.nextTurn();
                
                // Inform the players about the card skip
                System.out.println(GameManager.getCurrentPlayer().getName() + "'s turn has been skipped!");
                break;
            case CHR_PICK_TWO:
                
                GameManager.nextTurn();
                
                // Add two cards to the players deck
                for(int i = 0; i < 2; i++)
                {
                    // Get the current player(whose turn it is) and add a card from the deck
                    GameManager.getCurrentPlayer().drawCard();
                }
                break;
            case CHR_PICK_FOUR:
                
                // Call the getColourSwap method which returns a char from the Input class
                setColour(Input.getColourSwap());
                
                // Run the nextTurn method in GameManager, and inform the players
                GameManager.nextTurn();
                System.out.println(GameManager.getCurrentPlayer().getName() + "'s turn has been skipped. \n4 cards have been added to their deck!");
                
                // Add four cards to the players deck
                for(int i = 0; i < 4; i++)
                {
                    // Get the current player(whose turn it is) and add a card from the deck
                    GameManager.getCurrentPlayer().drawCard();
                }
                
                System.out.println("The colour is now: " + Deck.getCurrentCard().cardColour());
                break;
            case CHR_SWITCH:
           
                
                setColour(Input.getColourSwap());
                
                System.out.println("The colour is now: " + cardColour());
                break;
        }
    }
}
