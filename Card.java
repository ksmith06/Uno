
/**
 * Write a description of class Card here.
 *
 * @author (Ibraheem Dawod)
 * @version (2023-11-30)
 */
public class Card
{
    // Instance variables
    char chrColour, chrType;
    
    // Constant characters
    final char CHR_RED = 'r';
    final char CHR_BLUE = 'b';
    final char CHR_YELLOW = 'y';
    final char CHR_GREEN = 'g';
    final char CHR_SWITCH = 's';
    final char CHR_REVERSE = 'r';
    final char CHR_SKIP = 'x';
    final char CHR_PICK_TWO = 'y';
    final char CHR_PICK_FOUR = 'z';
    
    
    // Constructor, taking the card colour and type(numerial/special)
    public Card(char chrColour, char chrType) {
        
        // Set the card colour to the colour passed in
        this.chrColour = chrColour;
        
        // Set the card type to the card passed in
        this.chrType = chrType;
    }
    
    // Sets the face card of the Deck
    // Will be called by the Player class when playing a card
    // public void setFaceCard() {
        
        // // Set the colour of the face card of the deck to the current Card
        // Deck.chrCurrentColour = chrColour;
        
        // // Set the type of the face card to the current card type
        // Deck.chrCurrentType = chrType;
    // }
    
    @Override
    public String toString() {
        String strColour;
        String strType;
        switch(chrColour){
            case CHR_RED:
                strColour = "Red";
                break;
            case CHR_BLUE:
                strColour = "Blue";
                break;
            case CHR_GREEN:
                strColour = "Green";
                break;
            case CHR_YELLOW:
                strColour = "Yellow";
                break;
            default:
                strColour = "INVALID CARD COLOUR";
                break;
        }
        
        switch(chrType){
            case CHR_SWITCH:
                strType = "Switch colour";
                break;
            case CHR_REVERSE:
                strType = "Reverse";
                break;
            case CHR_SKIP:
                strType = "Skip turn";
                break;
            case CHR_PICK_TWO:
                strType = "Pick up 2";
                break;
            case CHR_PICK_FOUR:
                strType = "Pick up 4";
                break;
            default:
                strType = "INVALID CARD TYPE";
                break;
        }
        
        return strType + ": " + strColour;
    }
}
