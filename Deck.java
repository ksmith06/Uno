
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//import random class to grab a random card from the deck
import java.util.Random;

//import arraylist class to store the deck and discard pile
import java.util.ArrayList;

//import io class to read in file
import java.io.*;

public class Deck
{
    //delcare private static arraylists of type card to store the deck, and discard pile
    private static ArrayList<Card> arlDeck;
    private static ArrayList<Card> arlDiscardPile;
    
    //declare private static variables of type card to store the current card
    static Card currentCard;
    
    //create static non void method to return a random card from the deck
    public static Card drawCard()
    {
        //create a new instance of the random class
        Random rand = new Random();
        
        //declare and populate variable of type int with a number from 0-arlDeck size, minus 1
        int intRandNum = rand.nextInt(arlDeck.size() - 1);
        
        arlDeck.remove(intRandNum);
        
        return arlDeck.get(intRandNum);
        
    }
    
    public static Card getCurrentCard() { return currentCard; }
    
    //create void method to add a card to the discard pile
    public static void addToDiscardPile(Card playedCard)
    {
        //add played card to discard pile arraylist
        arlDiscardPile.add(playedCard);
        
        //set current card to the played card
        currentCard = playedCard;
    }
    
    //create void method to populate the deck from a file
    public void populateDeck()
    {
        //declare variables of type char to store colour and type of a card
        char chrColour, chrType;
        
        //declare variable of type byte to store the amount of that type of card
        byte bytNum;
        
        //declare variable of type boolean to use to loop until there are no more chars in the file
        boolean bolNoMoreChar = false;
        
        //create try catch to catch any IO, EOF, or FIleNotFound exceptions
        try 
        {
            //create new file reader for allcardsindeck file
            FileReader in = new FileReader("AllCardsInDeck.txt");
                
            //create do while loop to loop until it reaches the end of the file
            do
            {
                //populate chrType with the next character
                chrType = (char)in.read();
                
                //check if chrType is the % character, signifying end of file
                if(chrType == '%')
                {
                   //set bolNoMoreChar to true
                   bolNoMoreChar = true; 
                }
                else
                {
                    //populate chrColour with the nexet character
                    chrColour = (char)in.read();
                    
                    //populate bytNum with the next character cast as a byte;
                    bytNum = (byte)in.read();
                    
                    //loop until the amount of that type of card is maxed
                    for (int i = 0; i < bytNum; i++)
                    {
                        //add the card type to arlDeck
                        arlDeck.add(new Card(chrColour, chrType));
                    }        
                }        
            }
            while (bolNoMoreChar == true);
            
            //close the filereader
            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for     reading");
        } 
        catch (EOFException e) 
        {
            System.out.println("Error: EOF encountered, file          may be corrupt");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot read from file");
        }    
        
        System.out.println(arlDeck.get(0));
        System.out.println(arlDeck.get(1));
        System.out.println(arlDeck.get(2));
        System.out.println(arlDeck.get(3));
        System.out.println(arlDeck.get(4));
        System.out.println(arlDeck.get(5));
    }
}
