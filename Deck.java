
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

//import util classes to read in file
import java.util.*;

public class Deck
{
    //delcare private static arraylists of type card to store the deck, and discard pile
    private static ArrayList<Card> arlDeck = new ArrayList<Card>();
    private static ArrayList<Card> arlDiscardPile = new ArrayList<Card>();
    
    //declare private static variables of type card to store the current card
    static Card currentCard;
    
    //create static non void method to return a random card from the deck
    public static Card drawCard()
    {
        //create a new instance of the random class
        Random rand = new Random();
        
        //declare and populate variable of type int with a number from 0-arlDeck size, minus 1
        int intRandNum = rand.nextInt(arlDeck.size() - 1);
        
        return arlDeck.get(intRandNum);
        
    }
    
    //create void method to add a card to the discard pile
    public static void AddToDiscardPile(Card playedCard)
    {
        //add played card to discard pile arraylist
        arlDiscardPile.add(playedCard);
        
        //set current card to the played card
        currentCard = playedCard;
    }
    
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
                        arlDeck.add(new Card(chrColour, chrType));
                        
                    }        
                }        
            }
            while (bolNoMoreChar == false);
            
            //close the filereader
            in.close();
        }
        catch (FileNotFoundException e) {
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

        
        for (int i = 0; i < arlDeck.size(); i++)
        {
            System.out.println(arlDeck.get(i));
        }
        
        System.out.println(arlDeck.size());

    }
    
    



    
    
    


}
