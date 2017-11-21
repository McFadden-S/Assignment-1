/********************************************************************
 * Programmer:      McFadden
 * Class:           CS30S
 *
 * Assignment:      A1Q1
 * Program Name:    A1ArrayGen
 *
 * Description:     Writes 1000 random numbers to an output file
 *                  with five numbers per line
 *
 * Input:           No input required
 *
 * Output:          Writes 1000 random numbers to an output file
 *                  with five numbers per line
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.Random;
 

public class A1ArrayGen {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
        final int MAX = 1000;     //constant for max size of array
        final int RANGE = 100;   //constant for the range of number values that can be in array
    
    // ********** declaration of variables **********
    
    	String strin;				// string data input from keyboard
    	String strout;				// processed info string to be output
    	String bannerOut;			// string to print banner to message dialogs
    	
    	String prompt;				// prompt for use in input dialogs
    	
    	String delim = "[ :]+";		// delimiter string for splitting input string
    	String tabSpace = "      ";	// six spaces
    	
        int[] Rn = new int[MAX];        //array for the random numbers
        Random rand = new Random();     //creates a new random generator
        
        int counter = 0;                //counts numbers for when to put new line
    	
    	//BufferedReader fin = new BufferedReader(new FileReader("name of file"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("RandomNumbers.txt")));
    	
    // ********** Print output Banner **********
    
    	System.out.println("*******************************************");
    	System.out.println("Name:		McFadden");
    	System.out.println("Class:		CS30S");
    	System.out.println("Assignment:	A1ArrayGen");
    	System.out.println("*******************************************");

    	bannerOut = "*******************************************\n";
    	bannerOut += "Name:		McFadden\n";
    	bannerOut += "Class:		CS30S\n";
    	bannerOut += "Assignment:	A1ArrayGen\n";
    	bannerOut += "*******************************************\n\n";
    	
    	
 	    	
    // ************************ get input **********************

    // ************************ processing ***************************
    
        for (int i = 0; i < MAX; i++){ //loop to assign values to array
            
            //assignes a random value and adds one so it creates number
            //between 1 and 100 not 0 to 99
            Rn[i] = rand.nextInt(RANGE)+1;  
            
        }//end of assignment for loop
    
    // ************************ print output ****************************
        
        for (int i = 0; i < MAX; i++){ //for loop for output
            fout.print(Rn[i] + " "); //prints a number and adds space after
            counter++;  //adds one to counter since new number has been printed
            
            if (counter == 5){ //after the third adds a new line
                fout.println("");
                counter = 0; //resets counter since new space has been added.
            }//end of new line if
        }//end of output for
    
        // ******** closing message *********
        
        System.out.println("end of processing.");

        
        // ***** close streams *****
        
        //fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class
