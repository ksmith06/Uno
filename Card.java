
/**
 * The Card class will contain a Card Objects colour and type. 
 * This type can either be one of the five special cards, or a numerical card(0-9).
 * This class contains a contructor, and two methods. 
 * The first method sets the face card of the deck whenever a card is played onto it to the current card's colour and type.
 * The second is a toString which converts the character instance variables for colour and type into a String.
 *
 * @author (Ibraheem Dawod)
 * @version (2023-11-30)
 */

public class Card
{
    // Instance variables
    private char chrColour, chrType;
    
    // Constant values for card colours
    final char CHR_RED = 'r';
    final char CHR_BLUE = 'b';
    final char CHR_YELLOW = 'y';
    final char CHR_GREEN = 'g';
    final char CHR_COLOURLESS = 'z';
    
    // Constant values for card types
    final char CHR_PICK_TWO = 'a';
    final char CHR_SKIP = 'b';
    final char CHR_REVERSE = 'c';
    final char CHR_SWITCH = 'd';
    final char CHR_PICK_FOUR = 'e';
    
    
    // Constructor, taking the card colour and type(numerial/special)
    public Card(char chrColour, char chrType) {
        
        // Set the card colour to the colour passed in
        this.chrColour = chrColour;
        
        // Set the card type to the card passed in
        this.chrType = chrType;
    }
    
    // Getters & Setter for Card instance variables
    public char getColour() {
        return chrColour;
    }
    
    public char getType() {
        return chrType;
    } 

    public void setColour(char c) {
        
        // Logic to ensure the colour of the card being switched is one of the cards that has a customizable colour
        if(chrType == CHR_SWITCH || chrType == CHR_PICK_FOUR) {
            chrColour = c;
        }
    }
    
    public boolean isCompatible(Card c)
    {
        return chrColour == c.getColour() || chrType == c.getType() || chrColour == CHR_COLOURLESS;
    }
    
    protected String cardColour() {
        
        // Value for colour of card to return
        String strColour;
        
        // Switch case statement to outpout the colour of the card based on the variable "chrColour"
        // Colourless represents cards that allow you to choose the colour
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
            case CHR_COLOURLESS:
                strColour = "Colourless";
                break;
            default:
                strColour = "INVALID CARD COLOUR";
                break;
        }
        
        return strColour;
    }
    
    protected String cardType() {
        
        // Value for type of card to return
        String strType;
        
        // Switch case statement to outpout the type/number of the card based on the variable "chrType"
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
                
                // If the "chrType" is not a special character(if its a number, set "strType" to the chrType
                strType = Character.toString(chrType);
                break;
        }
        
        return strType;
    }
    
    @Override
    public String toString() {
        
        // Return the card type and colour
        return cardType() + ": " + cardColour();
    }
}
