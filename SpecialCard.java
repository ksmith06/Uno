
/**
 * The SpecialCard class contains a constructor and a cardEffect method.
 * This method enacts a special ability on the deck/players depending on the type of card.
 * 
 * @author (Ibraheem Dawod)
 * @version (2023-12-05)
 */
public class SpecialCard extends Card
{
    // Constant values for card types
    final char CHR_PICK_TWO = 'a';
    final char CHR_SKIP = 'b';
    final char CHR_REVERSE = 'c';
    final char CHR_SWITCH = 'd';
    final char CHR_PICK_FOUR = 'e';
    
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
                System.out.println(GameManager.arlPlayers.get(GameManager.bytPlayerTurn).strPlayerName + " has reversed the order of playing! \nIt is now " + GameManager.arlPlayers.get(GameManager.bytPlayerTurn + 1).strPlayerName + "'s turn.");
                
                // Run the nextTurn method in GameManager
                GameManager.nextTurn();
                break;
            case CHR_SKIP:
                
                // Run the nextTurn method in GameManager
                GameManager.nextTurn();
                
                // Inform the players about the card skip
                System.out.println(GameManager.arlPlayers.get(GameManager.bytPlayerTurn).strPlayerName + "'s turn has been skipped!");
                
                // Run the nextTurn method again
                GameManager.nextTurn();
                
                // Inform the players of the current players turn
                System.out.println("It is now " + GameManager.arlPlayers.get(GameManager.bytPlayerTurn).strPlayerName + "'s turn.");
                break;
            case CHR_PICK_TWO:
                
                // Run the nextTurn method in GameManager, and inform the players
                GameManager.nextTurn();
                System.out.println("It is now " + GameManager.arlPlayers.get(GameManager.bytPlayerTurn).strPlayerName + "'s turn.");
                
                // Add two cards to the players deck
                for(int i = 0; i < 2; i++){
                    
                    // Take a Card from the deck and store it
                    Card c = Deck.drawCard();
                    
                    // Get the current player(whose turn it is) and add a card from the deck
                    GameManager.arlPlayers.get(bytPlayerTurn).arlHand.add(c);
                    
                    // Print out the card drawn
                    System.out.println("\t" + c.cardColour());
                }
                break;
            case CHR_PICK_FOUR:
                
                // Call the getColourSwap method which returns a char from the Input class
                setColour(Input.getColourSwap());
                
                // Run the nextTurn method in GameManager, and inform the players
                GameManager.nextTurn();
                System.out.println("It is now " + GameManager.arlPlayers.get(GameManager.bytPlayerTurn).strPlayerName + "'s turn. \n4 cards have been added to their deck! The cards are: ");
                
                // Add four cards to the players deck
                for(int i = 0; i < 4; i++){
                    
                    // Take a Card from the deck and store it
                    Card c = Deck.drawCard();
                    
                    // Get the current player(whose turn it is) and add a card from the deck
                    GameManager.arlPlayers.get(bytPlayerTurn).arlHand.add(c);
                    
                    // Print out the card drawn
                    System.out.println("\t" + c.cardColour());
                }
                
                System.out.println("The colour is now " + Deck.getCurrentCard().cardColour());
                break;
            case CHR_SWITCH:
           
                
                setColour(Input.getColourSwap());
                
                // Run the nextTurn method in GameManager
                GameManager.nextTurn();
                break;
        }
    }
}
