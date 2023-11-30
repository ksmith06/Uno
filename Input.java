
/**
 * Author:
 */

//import Scanner class for user input
import java.util.Scanner;

//import arraylist class to take in user's hand
import java.util.ArrayList;
public class Input
{
    //create non void method to return users input
    public static byte getInput(String strPrompt, byte bytMax, byte bytMin)
    {
        //declare variable and initalise of type byte to store the user's input
        byte bytInput = 0;

         //declare and populate variable of type boolean to use for
        //the try and catch block
        boolean bolTryCatch = false;
 
        //create a do while to loop the try and catch until the user inputs the correct data type
        do
        {     
            //prompt the user
            prnt(strPrompt);
        
            //create a try and catch block to ensure that the user inputs the correct data type and catches any errors/incorrect data types
            try
            {
                //populate bytInput with user input from the Scanner class
                bytInput = new Scanner(System.in).nextByte();
 
                //set bolTryCatch to true to break loop
                bolTryCatch = true;
            }
            catch(Exception e)
            {
                //prompt user to enter the appropriate data type
                prnt("Please enter a number");
            }
    
            //create if statement to check if user chose one of the given otions
            if (bytInput > bytMax || bytInput < bytMin)
            {
                //prompt the user to enter a number
                prnt("We have limited your options from " + bytMin + " to " + bytMax);
                
                //set bolTryCatch to false to loop again
                bolTryCatch = false;
            }
        }
        //loop while bolTryCatch is false
        while(bolTryCatch == false);
 
        //return bytInput
        return bytInput;
    }
    
     //create non void method to return users input
    public static byte getInput(String strPrompt, byte bytMax)
    {
        //declare variable of type byte to store the min as 0;
        byte bytMin = 0;
        
        //call for getInput with prompt, max, and min parameters
        getInput(strPrompt, bytMax, bytMin);
    }
    
    public static byte getInput(ArrayList<Card> arlHand)
    {
        //declare variables of type byte to store the max and min of the arraylist
        byte bytMax = (byte)(arlHand.size() - 1);
        byte bytMin = 0;
        
        //declare variable of type string to output card options
        String strChoices = "Please select a card to play: ";
        
        //create for loop through every index of the array
        for (int i = 0; i <= bytMax + 1; i++)
        {
            //populate strChoices with every choice;
            strChoices += "\n" + i + " - " + arlHand.get(i);
            
            //check if i is byMax + 1
            if (i == bytMax + 1)
            {
                //populate strChoices with a Draw option
                 strChoices += "\n" + i + " - " + "Draw";
            }
        }
        
        //call for getInput with prompt, max, and min parameters
        getInput(strChoices, bytMax, bytMin);
    }
    
    //create void method to replace system.out
    public static void prnt(String strText)
    {
        //output strText
        System.out.println(strText);
    }
    
    
}