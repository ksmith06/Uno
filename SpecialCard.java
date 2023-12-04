
/**
 * Write a description of class SpecialCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpecialCard extends Card
{
    // Constant values for card types
    final char CHR_PICK_TWO = 'a';
    final char CHR_SKIP = 'b';
    final char CHR_REVERSE = 'c';
    final char CHR_SWITCH = 'd';
    final char CHR_PICK_FOUR = 'e';
    
    public SpecialCard(char chrColour, char chrType) {
        super(chrColour, chrType);
    }
    
    byte bytPlayerTurn = 0;
    // Move to GameManager
    static public void nextTurn(){
        if(bytPlayerTurn+1 > arlPlayers.size()-1) {
            bytPlayerTurn = 0;
        } else {
            bytPlayerTurn++;
        }
    }
    
    public void cardEffect() {
        // ACCESS INPUT METHOD WHICH ASKS USER WHAT COLOUR THEY WANT
        // STORE THAT COLOUR
        switch(super.getType()){
            case CHR_REVERSE:
                // REVERSE ORDER OF PLAYERS IN ARRAY LIST OF PLAYERS
                // GameManager.arlPlayers
                ArrayList<Player> arlNewOrder = new ArrayList<Player>();
                for(int i = 0; i<GameManager.arlPlayers.size(); i++) {
                    arlNewOrder.add(GameManager.arlPlayers.get(GameManager.arlPlayers.size() - 1 - i));
                }
                GameManager.arlPlayers = arlNewOrder;
                GameManager.nextTurn();
                break;
            case CHR_SKIP:
                // SKIP TURN OF NEXT PLAYER
                // Add 2 to byte keeping track of which player it is to play
                // Skip back to beginning if you reach end of Player ArrayList
                // if(GameManager.bytPlayerTurn+1 > GameManager.arlPlayers.size()-1) {
                    // GameManager.bytPlayerTurn = 1;
                // } else if(GameManger.bytPlayerTurn+2 > GameManager.arlPlayers.size()-1) {
                    // GameManager.bytPlayerTurn = 0;
                // }
                for(int i = 0; i < 2; i++){
                    GameManager.nextTurn();
                }
                break;
            case CHR_PICK_TWO:
                // MAKE NEXT PLAYER PICK UP 2 CARDS
                GameManager.nextTurn();
                for(int i = 0; i < 2; i++){
                    GameManager.arlPlayers.get(bytPlayerTurn).arlHand.add(Deck.drawCard());
                }
                break;
            
        }
    }
    
    public void cardEffect(char chrPlayerChoice){
        switch(super.getType()){
            case CHR_PICK_FOUR:
                // MAKE NEXT PLAYER PICK UP 4 CARDS
                // CHANGE COLOUR TO CURRENT PLAYERS CHOICE
                Deck.currentCard.setColour(chrPlayerChoice);
                GameManager.nextTurn();
                for(int i = 0; i < 4; i++){
                    GameManager.arlPlayers.get(bytPlayerTurn).arlHand.add(Deck.drawCard());
                }
                break;
            case CHR_SWITCH:
                // CHANGE COLOUR TO CURRENT PLAYERS CHOICE
                Deck.currentCard.setColour(chrPlayerChoice);
                GameManager.nextTurn();
                break;
        }
    }
}
