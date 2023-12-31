
/**
 * Author: Raymond Tan
 * Date: 12/04/2023
 * Decscription: This class repressents the deck used in the game. It is populated by a file that contains every card in the deck. 
 * The deck class contains the decl, discardpile AND the current card. This class allows a card to be drawn from the deck and allows a card
 * to be placed into the discard pile, which changes the current card.
 */
//import random class to grab a random card from the deck
import java.util.Random;

//import arraylist class to store the deck and discard pile
import java.util.ArrayList;

//import io class to read in file
import java.io.*;

//import util classes to read in file
import java.util.*;

public class Deck
{
    //delcare private static arraylists of type card to store the deck, and discard pile
    private static ArrayList<Card> arlDeck = new ArrayList<Card>();
    private static ArrayList<Card> arlDiscardPile = new ArrayList<Card>();
    
    //declare private static variable of type card to store the current card
    private static Card currentCard;
    
    /**
    * Author: Raymond Tan
    * Date: 12/04/2023
    * Decscription: This method allows the users to draw a card from the deck. It grabs a random card from the deck, removes that card from the 
    * deck, and returns it.
    */
    //create static non void method to return a random card from the deck
    public static Card drawCard()
    {
        //create a new instance of the random class
        Random rand = new Random();
        
        //declare and populate variable of type int with a number from 0-arlDeck size, minus 1
        int intRandNum = rand.nextInt(arlDeck.size());
        
        Card drawnCard = arlDeck.remove(intRandNum);
        
        if (arlDeck.size() == 0)
        {
            arlDeck = arlDiscardPile;
            arlDiscardPile.clear();
        }
        
        //return and remove the card
        return drawnCard;
    }

    /**
    * Author: Raymond Tan
    * Date: 12/04/2023
    * Decscription: This method adds a played card to the discard pile and changes the current card to that played card.
    */
    public static void addToDiscardPile(Card playedCard)
    {
        //add played card to discard pile arraylist
        arlDiscardPile.add(playedCard);
        
        //set current card to the played card
        currentCard = playedCard;
    }
    
    /**
    * Author: Raymond Tan
    * Date: 12/04/2023
    * Decscription: This method populates the deck with a read in file that contains all the cards.
    */
    //create void method to populate the deck from a file
    public static void populateDeck()
    {
        //declare variables of type char to store colour of and type of special card
        char chrColour, chrType;
        
        //declare variable of type byte to store the amount of that type of card
        byte bytNum;
        
        //declare variable of type boolean to use to loop until there are no more chars in the file
        boolean bolNoMoreChar = false;
        
        //declare variable of type String to store the read in line
        String strLine;
        
        //create try catch to catch any IO, EOF, or FIleNotFound exceptions
        try 
        {
            //create new file reader for allcardsindeck file
            Scanner in = new Scanner(new FileReader("AllCardsInDeck.txt"));
                
            //create do while loop to loop until it reaches the end of the file
            do
            {
                //set strLine to the next line of the file
                strLine = in.nextLine();
                
                //populate chrType with the next character
                chrType = strLine.charAt(0);

                //check if chrType is the % character, signifying end of file
                if(chrType == 'm')
                {
                   //set bolNoMoreChar to true
                   bolNoMoreChar = true; 
                }
                else
                {
                    //populate chrColour with the next character
                    chrColour = strLine.charAt(1);
                    
                    //populate bytNum with the next character cast as a byte
                    bytNum = (byte)(Character.getNumericValue(strLine.charAt(2)));
                    
                    //loop until the amount of that type of card is maxed
                    for (int i = 0; i < bytNum; i++)
                    {
                        //add the card type to arlDeck
                        if (Character.isDigit(chrType))
                        {
                            arlDeck.add(new Card(chrColour, chrType));
                        }
                        else
                        {
                            arlDeck.add(new SpecialCard(chrColour, chrType));
                        }
                    }        
                }        
            }
            while (bolNoMoreChar == false);
            
            //close the filereader
            in.close();
            
            addToDiscardPile(drawCard());
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for reading");
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Error: EOF encountered, file may be corrupt");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot read from file");
        } 
    }
    
    /**
    * Author: Raymond Tan
    * Date: 12/04/2023
    * Decscription: This method returns the current card.
    */
    //Create getters to get the current card
    public static Card getCurrentCard()
    {
        return currentCard;
    }
}
