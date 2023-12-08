/**
 * Author: Raymond Tan
 * Date: 12/01/2023
 * Description: This class deals with any user input, including colour swapping and users card choice. All methods will be ran through a try
 * catch block to ensure there are no input errors.
 */

//import Scanner class for user input
import java.util.Scanner;

//import arraylist class to take in user's hand
import java.util.ArrayList;
public class Input
{
    /**
    * Author: Raymond Tan
    * Date: 12/01/2023
    * Description: This overloaded method will take in a prompt, a max, and a min. It will prompt a user for input and will return the users
    * choice as a byte that has gone through a try and catch block to ensure no input errors.
    */
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
    
    public static void awaitInput()
    {
        new Scanner(System.in).nextLine();
    }
    
    public static String getStringInput(String strPrompt)
    {
        System.out.println(strPrompt);
        
        return new Scanner(System.in).nextLine();
    }
    

    /**
    * Author: Raymond Tan
    * Date: 12/01/2023
    * Description: This overloaded method will take in a prompt, and a max. It assumes the min is 0 and will then pass the information
    * into getInput and return the returned value
    */
    public static byte getInput(String strPrompt, byte bytMax)
    {
        //declare variable of type byte to store the min as 0;
        byte bytMin = 0;
        
        //call for getInput with prompt, max, and min parameters
        return getInput(strPrompt, bytMax, bytMin);
    }
    
    /**
    * Author: Raymond Tan
    * Date: 12/01/2023
    * Description: This overloaded method will take in a users hand. It will output the users card choices from their hand
    * It will pass in the information into getInput, and it will return the returned value.
    */
    public static byte getInput(ArrayList<Card> arlHand)
    {
        //declare variables of type byte to store the max and min of the arraylist
        byte bytMax = (byte) (arlHand.size() + 1);
        byte bytMin = 1;
        
        //declare variable of type string to output card options
        String strChoices = "Please select a card to play: ";
        
        //create for loop through every index of the array
        for (int i = 0; i < bytMax - 1; i++)
        {
            //populate strChoices with every choice;
            strChoices += "\n" + (i + 1) + " - " + arlHand.get(i);
        }
        
        strChoices += "\n" + bytMax + " - " + "Draw";
        
        //call for getInput with prompt, max, and min parameters
        return getInput(strChoices, bytMax, bytMin);
    }
    
    /**
    * Author: Raymond Tan
    * Date: 12/05/2023
    * Description: This method will take in a user input concerning swapping the current colour of the game. It will pass the prompt, max,
    * and min into getInput which will then return a byte that has gone trhough a try catch. It will then correspond the byte value to a
    * char and return it.
    */
    public static char getColourSwap()
    {
        //declare a variable of type byte to store user response
        byte bytChoice;
        
        //declare a variable of type char to return users choice as a char
        char chrChoice;
        
        //declare constants of type byte to store min and maximum choices
        final byte BYT_MIN = 1, BYT_MAX = 4;
        
        //declare constant of type string to store the prompt
        final String STR_PROMPT = 
        "Please choose a colour to swap to" 
        + "\n1 - red"
        + "\n2 - yellow"
        + "\n3 - blue"
        + "\n4 - green";
        
        //populate bytChoice with userinput that has been passed through a try and catch from get input
        bytChoice = getInput(STR_PROMPT, BYT_MAX, BYT_MIN);
        
        //check bytChoice and populate chrChoice with the users choice as a char
        switch (bytChoice)
        {
            case 1:
            chrChoice = 'r';
            break;
            
            case 2:
            chrChoice = 'y';
            break;
            
            case 3:
            chrChoice = 'b';
            break;
            
            case 4:
            chrChoice = 'g';
            break;
            
            default:
            chrChoice = '%';
            break;
        }
        
        //return chrChoice
        return chrChoice;

    }
    
    /**
    * Author: Raymond Tan
    * Date: 12/01/2023
    * Description: This method will replace system.out.println
    */
    public static void prnt(String strText)
    {
        //output strText
        System.out.println(strText);
    }
    
    
}